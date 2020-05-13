package com.mapbox.samples;

import com.google.gson.JsonObject;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.Point;
import com.mapbox.sample.BuildConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasicGeocoding {

  public static void main(String[] args) {
    MapboxGeocoding geocoding = MapboxGeocoding.builder()
            .accessToken(BuildConfig.MAPBOX_ACCESS_TOKEN)
            .query("đường ngô quyền")
            .bbox(BoundingBox.fromLngLats(106.564077 , 20.661891, 106.130391, 21.247567))
            .proximity(Point.fromLngLat(106.342640, 20.938797))
//            .query(Point.fromLngLat(10.8548, 106.67))
            .build();

    geocoding.enqueueCall(new Callback<JsonObject>() {
      @Override
      public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        System.out.println("on response " + response.body().toString());
      }

      @Override
      public void onFailure(Call<JsonObject> call, Throwable t) {
        System.out.println("on failure");
      }
    });
  }

//  public static void main(String[] args) {
//    try {
//      String json = "{\"place_id\":1,\"osm_type\":\"node\",\"osm_od\":1,\"lat\":21.0340784,\"lon\":105.8344746,\"display_name\":\"31 Hùng Vương, Phường Điện Biên, Quận Ba Đình, Thành phố Hà Nội\",\"address\":{\"road\":\"Đường Hùng Vương\",\"suburb\":\"Phường Điện Biên\",\"town\":\"Quận Ba Đình\",\"city\":\"Thành phố Hà Nội\",\"country\":\"Viêt Nam\",\"country_code\":\"vn\"}}";
//      GeocodingResponse response = GeocodingResponse.fromJson(json);
//      System.out.println(response);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
}
