/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyJson;

import Model.QlPhong;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
        JSONArray json = new JSONArray(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
  
  public static ArrayList<Model.QlPhong> convertJSONArrayToArrayList(JSONArray jsona){
      ArrayList<Model.QlPhong> ds = new ArrayList<>();
      if(jsona!=null){
          for( int i = 0; i < jsona.length(); i++){
              try {
                  JSONObject jSONObject = jsona.getJSONObject(i);
                  ds.add(new QlPhong(
                          jSONObject.getString("MAPHONG"),
                          jSONObject.getString("TENPHONG"),
                          jSONObject.getString("LOAIPHONG"), (float) jSONObject.getDouble("GIAPHONG"),
                          jSONObject.getString("CHUTHICH"),
                          jSONObject.getString("TINHTRANG")));
              } catch (JSONException ex) {
                  Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
              }
             
             
          }
      }
      return ds;
  }
  public String getPhongWithName(String tenphong,String urlget) throws MalformedURLException, UnsupportedEncodingException, IOException{
      StringBuilder sb = new StringBuilder();
      URL url = new URL(urlget);
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("tenphong",tenphong);
        

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;){
            sb.append((char)c);}
        return sb.toString();
        
  }
  public static String insertPhong(QlPhong qp,String urlInsert) throws MalformedURLException, UnsupportedEncodingException, IOException{
      StringBuilder sb = new StringBuilder();
      URL url = new URL(urlInsert);
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("maphong",qp.getMaphong());
        params.put("tenphong",qp.getTenphong());
        params.put("loaiphong",qp.getLoaiphong());
        params.put("giaphong",qp.getGiaphong());
        params.put("chuthich",qp.getChuthich());
        params.put("tinhtrang",qp.getTinhtrang());
        

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;){
            sb.append((char)c);}
        return sb.toString();
        
  }
  public static String insertPhong2(QlPhong qp,String urlInsert) throws MalformedURLException, UnsupportedEncodingException, IOException{
      StringBuilder sb = new StringBuilder();
      URL url = new URL(urlInsert);
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("maphong",qp.getMaphong());
        params.put("tenphong",qp.getTenphong());
        params.put("loaiphong",qp.getLoaiphong());
        params.put("giaphong",qp.getGiaphong());
        params.put("chuthich",qp.getChuthich());
        params.put("tinhtrang",qp.getTinhtrang());
        
        

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;){
            sb.append((char)c);}
        return sb.toString();
        
  }
//  private String setStatus(){
//      StringBuilder postData = new StringBuilder();
//        for (Map.Entry<String,Object> param : params.entrySet()) {
//            if (postData.length() != 0) postData.append('&');
//            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//            postData.append('=');
//            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//        }
//        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
//        conn.setDoOutput(true);
//        conn.getOutputStream().write(postDataBytes);
//
//        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//
//        for (int c; (c = in.read()) >= 0;){
//            sb.append((char)c);}
//  }
   public static String updatePhong(QlPhong qp,String urlUpdate) throws MalformedURLException, UnsupportedEncodingException, IOException{
      StringBuilder sb = new StringBuilder();
      URL url = new URL(urlUpdate);
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("maphong",qp.getMaphong());
        params.put("tenphong",qp.getTenphong());
        params.put("loaiphong",qp.getLoaiphong());
        params.put("giaphong",qp.getGiaphong());
        params.put("chuthich",qp.getChuthich());
        params.put("tinhtrang",qp.getTinhtrang());
          

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;){
            sb.append((char)c);}
        return sb.toString();
        
  }
   public static String updateTinhTrang(String maphong,String urlUpdate) throws MalformedURLException, UnsupportedEncodingException, IOException{
      StringBuilder sb = new StringBuilder();
      URL url = new URL(urlUpdate);
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("maphong",maphong);
        
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;){
            sb.append((char)c);}
        return sb.toString();
        
  }
   public static String deletePhong(QlPhong phong,String urlUpdate) throws MalformedURLException, UnsupportedEncodingException, IOException{
      StringBuilder sb = new StringBuilder();
      URL url = new URL(urlUpdate);
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("maphong",phong.getMaphong());
        
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;){
            sb.append((char)c);}
        return sb.toString();
        
  }
  
  public static void main(String[] args) throws IOException, JSONException {
   // JSONArray json = readJsonFromUrl("http://localhost/QLKS_Phong/getAllData.php");
    //ArrayList<Model.QlPhong> ds = convertJSONArrayToArrayList(json);
    
   // for( int i = 0; i < ds.size(); i++ ){
       // System.out.println(ds.get(i).getTenphong());
  //  }
      //System.out.println(insertPhong(new QlPhong("234453", "123", "123", 1, "123", "con", "nv01", "dv01"),"http://localhost/QLKS_Phong/insertPhong.php"));
  }
}
