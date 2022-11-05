package Recursion;

import java.util.ArrayList;

public class RestoreIPAddress {
    static ArrayList<ArrayList<String>> valid_ips = new ArrayList<>();
    static ArrayList<String> part_address = new ArrayList<>();
    public static void main(String[] args){
      String ipAddress = "25525511135";
      generateValidIps(ipAddress,4,0);
      System.out.println(valid_ips);
    }

    private static void generateValidIps(String ipAddress, int dots, int index) {
        if(index > ipAddress.length()-1){
            return;
        }
        if(dots == 1){
            String part = ipAddress.substring(index);
            if(isValid(part)){
                ArrayList<String> temp = new ArrayList<>(part_address);
                temp.add(part);
                valid_ips.add(temp);
            }
            return;
        }
        for(int i=index; i<ipAddress.length(); i++){
            String part = ipAddress.substring(index,i+1);
            dots--;
            part_address.add(part);
            if(isValid(part)){
                generateValidIps(ipAddress,dots,i+1);
            }
            dots++;
            part_address.remove(part_address.size()-1);
        }
    }

    private static boolean isValid(String part) {
        if(part.length()>1 && part.charAt(0)=='0'){
            return false;
        }
        long integer = Long.parseLong(part);
        if(integer > 255){
            return false;
        }
        return true;
    }
}
