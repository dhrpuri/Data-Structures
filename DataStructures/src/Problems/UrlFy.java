package Problems;

class UrlFy {
    public static void main(String[] args) {
        String s1 = "null null";
        System.out.println("urlfy  = " + urlfy(s1));
    }

    public static String urlfy(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder strBuilder = new StringBuilder();
        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            strBuilder.append(strArray[i]);
            if (i != strArray.length - 1) {
                strBuilder.append("%20");
            }
        }
        return strBuilder.toString();
    }
}
