package com.example.shalin.donatetoday;

public class Common {

    private static String DB_NAME = "donate";
    private static String COLLECTION_NAME = "hospital";
    private static String COLLECTION_NAME1 = "request";

    public static String API_KEY = "5CrjFot1x_U4DHykvSejC3MC1X-lNEGF";

   /* public static String getAddressSingle(User user) {
        String baseurl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME, COLLECTION_NAME);
        StringBuilder sb = new StringBuilder(baseurl);
        sb.append("/"+user.get_id().getoid()+"?apiKey="+API_KEY);
        return sb.toString();
    }*/


    public static String getAddressAPI(){
        String baseurl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME, COLLECTION_NAME);
        StringBuilder sb = new StringBuilder(baseurl);
        sb.append("?apiKey="+API_KEY);
        return sb.toString();
    }

   /* public static String getAddressSingle1(User user) {
        String baseurl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME, COLLECTION_NAME1);
        StringBuilder sb = new StringBuilder(baseurl);
        sb.append("/"+user.get_id().getoid()+"?apiKey="+API_KEY);
        return sb.toString();
    }*/

    public static String getAddressAPI1(){
        String baseurl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME, COLLECTION_NAME1);
        StringBuilder sb = new StringBuilder(baseurl);
        sb.append("?apiKey="+API_KEY);
        return sb.toString();
    }


}
