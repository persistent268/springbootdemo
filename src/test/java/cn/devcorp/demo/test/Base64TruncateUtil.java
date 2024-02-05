package cn.devcorp.demo.test;

public class Base64TruncateUtil {
    /**
     * Truncates a Base64 encoded string to a specified maximum length. If the length of
     * the Base64 string is less than or equal to the specified max length, the original
     * string is returned. This does not consider padding or actual binary data length.
     *
     * @param base64String the original Base64 encoded string.
     * @param maxLength    the maximum length of the encoded string to keep.
     * @return a truncated Base64 string or the original string if it's short enough.
     */
    public static String truncateBase64String(String base64String, int maxLength) {
        if (base64String == null) {
            return null;
        }
        // Ensure that the maxLength is greater than 0 and not larger than the string length
        maxLength = Math.min(maxLength, base64String.length());
        // Optional: Adjust maxLength to be a multiple of 4 to respect Base64 paddings
        maxLength = maxLength - (maxLength % 4);

        return (base64String.length() <= maxLength) ? base64String : base64String.substring(0, maxLength) + "...";
    }

    // Example usage
    public static void main(String[] args) {
        String originalBase64String = "SGVsbG8gdGhpcyBpcyBhbiBleGFtcGxlIG9mIGEgdmVyeSBsb25nIEJhc2U2NCBlbmNvZGVkIHN0cmluZw==";
        // Specify the maximum length you want for the Base64 string
        int maxLength = 20;

        String truncatedBase64String = truncateBase64String(originalBase64String, maxLength);
        System.out.println("Original: " + originalBase64String);
        System.out.println("Truncated: " + truncatedBase64String);
    }
}