import java.util.Scanner;

public class Main {

    public static String parseAbbreviationToFullIPv6(String abbreviation) {
        String fullIPv6 = "";
        if ("::".equals(abbreviation)) {
            return "0000:0000:0000:0000:0000:0000:0000:0000";
        }

        String[] arr = new String[]{"0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000"};
        if (abbreviation.startsWith("::")) {
            String[] temp = abbreviation.substring(2, abbreviation.length()).split(":");
            for (int i = 0; i < temp.length; i++) {
                String tempStr = "0000" + temp[i];
                arr[i + 8 - temp.length] = tempStr.substring(tempStr.length() - 4);
            }
        } else if (abbreviation.endsWith("::")) {
            String[] temp = abbreviation.substring(0, abbreviation.length() - 2).split(":");
            for (int i = 0; i < temp.length; i++) {
                String tempStr = "0000" + temp[i];
                arr[i] = tempStr.substring(tempStr.length() - 4);
            }
        } else if (abbreviation.contains("::")) {
            String[] tempArr = abbreviation.split("::");
            String[] temp0 = tempArr[0].split(":");
            for (int i = 0; i < temp0.length; i++) {
                String tempStr = "0000" + temp0[i];
                arr[i] = tempStr.substring(tempStr.length() - 4);
            }
            String[] temp1 = tempArr[1].split(":");
            for (int i = 0; i < temp1.length; i++) {
                String tempStr = "0000" + temp1[i];
                arr[i + 8 - temp1.length] = tempStr.substring(tempStr.length() - 4);
            }
        } else {
            String[] tempArr = abbreviation.split(":");
            for (int i = 0; i < tempArr.length; i++) {
                String tempStr = "0000" + tempArr[i];
                arr[i] = tempStr.substring(tempStr.length() - 4);
            }
        }

        //fullIPv6 = StringUtils.join(arr, ":");
        String tmp = arr[0];
        for(int i = 1; i < arr.length;i++){
            //System.out.println(arr[i]);
            tmp += ":"+arr[i];
        }
        //return fullIPv6;
        return tmp;
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String t = cin.nextLine();
        //System.out.println(t);
        int n = Integer.parseInt(t);
        for(int i = 0; i < n; i++){
            String tt = cin.nextLine();
            System.out.println(parseAbbreviationToFullIPv6(tt));
        }

    }
}

