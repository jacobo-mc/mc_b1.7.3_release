package net.minecraft.src;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public final class J_SajParser {
    public void parse(Reader var1, J_JsonListener var2) throws J_InvalidSyntaxException, IOException {
        J_PositionTrackingPushbackReader var3 = new J_PositionTrackingPushbackReader(var1);
        char var4 = (char)var3.read();
        switch(var4) {
        case '[':
            var3.unread(var4);
            var2.startDocument();
            this.arrayString(var3, var2);
            break;
        case '{':
            var3.unread(var4);
            var2.startDocument();
            this.objectString(var3, var2);
            break;
        default:
            throw new J_InvalidSyntaxException("Expected either [ or { but got [" + var4 + "].", var3);
        }

        int var5 = this.readNextNonWhitespaceChar(var3);
        if (var5 != -1) {
            throw new J_InvalidSyntaxException("Got unexpected trailing character [" + (char)var5 + "].", var3);
        } else {
            var2.endDocument();
        }
    }

    private void arrayString(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws J_InvalidSyntaxException, IOException {
        char var3 = (char)this.readNextNonWhitespaceChar(var1);
        if (var3 != '[') {
            throw new J_InvalidSyntaxException("Expected object to start with [ but got [" + var3 + "].", var1);
        } else {
            var2.startArray();
            char var4 = (char)this.readNextNonWhitespaceChar(var1);
            var1.unread(var4);
            if (var4 != ']') {
                this.aJsonValue(var1, var2);
            }

            boolean var5 = false;

            while(!var5) {
                char var6 = (char)this.readNextNonWhitespaceChar(var1);
                switch(var6) {
                case ',':
                    this.aJsonValue(var1, var2);
                    break;
                case ']':
                    var5 = true;
                    break;
                default:
                    throw new J_InvalidSyntaxException("Expected either , or ] but got [" + var6 + "].", var1);
                }
            }

            var2.endArray();
        }
    }

    private void objectString(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws J_InvalidSyntaxException, IOException {
        char var3 = (char)this.readNextNonWhitespaceChar(var1);
        if (var3 != '{') {
            throw new J_InvalidSyntaxException("Expected object to start with { but got [" + var3 + "].", var1);
        } else {
            var2.startObject();
            char var4 = (char)this.readNextNonWhitespaceChar(var1);
            var1.unread(var4);
            if (var4 != '}') {
                this.aFieldToken(var1, var2);
            }

            boolean var5 = false;

            while(!var5) {
                char var6 = (char)this.readNextNonWhitespaceChar(var1);
                switch(var6) {
                case ',':
                    this.aFieldToken(var1, var2);
                    break;
                case '}':
                    var5 = true;
                    break;
                default:
                    throw new J_InvalidSyntaxException("Expected either , or } but got [" + var6 + "].", var1);
                }
            }

            var2.endObject();
        }
    }

    private void aFieldToken(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws J_InvalidSyntaxException, IOException {
        char var3 = (char)this.readNextNonWhitespaceChar(var1);
        if ('"' != var3) {
            throw new J_InvalidSyntaxException("Expected object identifier to begin with [\"] but got [" + var3 + "].", var1);
        } else {
            var1.unread(var3);
            var2.startField(this.stringToken(var1));
            char var4 = (char)this.readNextNonWhitespaceChar(var1);
            if (var4 != ':') {
                throw new J_InvalidSyntaxException("Expected object identifier to be followed by : but got [" + var4 + "].", var1);
            } else {
                this.aJsonValue(var1, var2);
                var2.endField();
            }
        }
    }

    private void aJsonValue(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws J_InvalidSyntaxException, IOException {
        char var3 = (char)this.readNextNonWhitespaceChar(var1);
        switch(var3) {
        case '"':
            var1.unread(var3);
            var2.stringValue(this.stringToken(var1));
            break;
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            var1.unread(var3);
            var2.numberValue(this.numberToken(var1));
            break;
        case '[':
            var1.unread(var3);
            this.arrayString(var1, var2);
            break;
        case 'f':
            char[] var6 = new char[4];
            int var7 = var1.read(var6);
            if (var7 == 4 && var6[0] == 'a' && var6[1] == 'l' && var6[2] == 's' && var6[3] == 'e') {
                var2.falseValue();
                break;
            }

            var1.uncount(var6);
            throw new J_InvalidSyntaxException("Expected 'f' to be followed by [[a, l, s, e]], but got [" + Arrays.toString(var6) + "].", var1);
        case 'n':
            char[] var8 = new char[3];
            int var9 = var1.read(var8);
            if (var9 != 3 || var8[0] != 'u' || var8[1] != 'l' || var8[2] != 'l') {
                var1.uncount(var8);
                throw new J_InvalidSyntaxException("Expected 'n' to be followed by [[u, l, l]], but got [" + Arrays.toString(var8) + "].", var1);
            }

            var2.nullValue();
            break;
        case 't':
            char[] var4 = new char[3];
            int var5 = var1.read(var4);
            if (var5 != 3 || var4[0] != 'r' || var4[1] != 'u' || var4[2] != 'e') {
                var1.uncount(var4);
                throw new J_InvalidSyntaxException("Expected 't' to be followed by [[r, u, e]], but got [" + Arrays.toString(var4) + "].", var1);
            }

            var2.trueValue();
            break;
        case '{':
            var1.unread(var3);
            this.objectString(var1, var2);
            break;
        default:
            throw new J_InvalidSyntaxException("Invalid character at start of value [" + var3 + "].", var1);
        }

    }

    private String numberToken(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        StringBuilder var2 = new StringBuilder();
        char var3 = (char)var1.read();
        if ('-' == var3) {
            var2.append('-');
        } else {
            var1.unread(var3);
        }

        var2.append(this.nonNegativeNumberToken(var1));
        return var2.toString();
    }

    private String nonNegativeNumberToken(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        StringBuilder var2 = new StringBuilder();
        char var3 = (char)var1.read();
        if ('0' == var3) {
            var2.append('0');
            var2.append(this.possibleFractionalComponent(var1));
            var2.append(this.possibleExponent(var1));
        } else {
            var1.unread(var3);
            var2.append(this.nonZeroDigitToken(var1));
            var2.append(this.digitString(var1));
            var2.append(this.possibleFractionalComponent(var1));
            var2.append(this.possibleExponent(var1));
        }

        return var2.toString();
    }

    private char nonZeroDigitToken(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        char var3 = (char)var1.read();
        switch(var3) {
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            return var3;
        default:
            throw new J_InvalidSyntaxException("Expected a digit 1 - 9 but got [" + var3 + "].", var1);
        }
    }

    private char digitToken(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        char var3 = (char)var1.read();
        switch(var3) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            return var3;
        default:
            throw new J_InvalidSyntaxException("Expected a digit 1 - 9 but got [" + var3 + "].", var1);
        }
    }

    private String digitString(J_PositionTrackingPushbackReader var1) throws IOException {
        StringBuilder var2 = new StringBuilder();
        boolean var3 = false;

        while(!var3) {
            char var4 = (char)var1.read();
            switch(var4) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                var2.append(var4);
                break;
            default:
                var3 = true;
                var1.unread(var4);
            }
        }

        return var2.toString();
    }

    private String possibleFractionalComponent(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        StringBuilder var2 = new StringBuilder();
        char var3 = (char)var1.read();
        if (var3 == '.') {
            var2.append('.');
            var2.append(this.digitToken(var1));
            var2.append(this.digitString(var1));
        } else {
            var1.unread(var3);
        }

        return var2.toString();
    }

    private String possibleExponent(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        StringBuilder var2 = new StringBuilder();
        char var3 = (char)var1.read();
        if (var3 != '.' && var3 != 'E') {
            var1.unread(var3);
        } else {
            var2.append('E');
            var2.append(this.possibleSign(var1));
            var2.append(this.digitToken(var1));
            var2.append(this.digitString(var1));
        }

        return var2.toString();
    }

    private String possibleSign(J_PositionTrackingPushbackReader var1) throws IOException {
        StringBuilder var2 = new StringBuilder();
        char var3 = (char)var1.read();
        if (var3 != '+' && var3 != '-') {
            var1.unread(var3);
        } else {
            var2.append(var3);
        }

        return var2.toString();
    }

    private String stringToken(J_PositionTrackingPushbackReader var1) throws J_InvalidSyntaxException, IOException {
        StringBuilder var2 = new StringBuilder();
        char var3 = (char)var1.read();
        if ('"' != var3) {
            throw new J_InvalidSyntaxException("Expected [\"] but got [" + var3 + "].", var1);
        } else {
            boolean var4 = false;

            while(!var4) {
                char var5 = (char)var1.read();
                switch(var5) {
                case '"':
                    var4 = true;
                    break;
                case '\\':
                    char var6 = this.escapedStringChar(var1);
                    var2.append(var6);
                    break;
                default:
                    var2.append(var5);
                }
            }

            return var2.toString();
        }
    }

    private char escapedStringChar(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        char var3 = (char)var1.read();
        char var2;
        switch(var3) {
        case '"':
            var2 = '"';
            break;
        case '/':
            var2 = '/';
            break;
        case '\\':
            var2 = '\\';
            break;
        case 'b':
            var2 = '\b';
            break;
        case 'f':
            var2 = '\f';
            break;
        case 'n':
            var2 = '\n';
            break;
        case 'r':
            var2 = '\r';
            break;
        case 't':
            var2 = '\t';
            break;
        case 'u':
            var2 = (char)this.hexadecimalNumber(var1);
            break;
        default:
            throw new J_InvalidSyntaxException("Unrecognised escape character [" + var3 + "].", var1);
        }

        return var2;
    }

    private int hexadecimalNumber(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
        char[] var2 = new char[4];
        int var3 = var1.read(var2);
        if (var3 != 4) {
            throw new J_InvalidSyntaxException("Expected a 4 digit hexidecimal number but got only [" + var3 + "], namely [" + String.valueOf(var2, 0, var3) + "].", var1);
        } else {
            try {
                int var4 = Integer.parseInt(String.valueOf(var2), 16);
                return var4;
            } catch (NumberFormatException var6) {
                var1.uncount(var2);
                throw new J_InvalidSyntaxException("Unable to parse [" + String.valueOf(var2) + "] as a hexidecimal number.", var6, var1);
            }
        }
    }

    private int readNextNonWhitespaceChar(J_PositionTrackingPushbackReader var1) throws IOException {
        boolean var3 = false;

        int var2;
        do {
            var2 = var1.read();
            switch(var2) {
            case 9:
            case 10:
            case 13:
            case 32:
                break;
            default:
                var3 = true;
            }
        } while(!var3);

        return var2;
    }
}
