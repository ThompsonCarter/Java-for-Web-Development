
@SpringBootTest(webEnvironment = RANDOM_PORT)
class TaskE2E {

 @LocalServerPort int port;

 @Test void lifeCycle() {
   String url = "http://localhost:"+port+"/api/tasks";
   int id = given().body("{"desc":"write book"}")
        .contentType("application/json").post(url)
        .then().statusCode(201).extract().path("id");
   given().get(url+"/"+id).then().statusCode(200)
        .body("desc",equalTo("write book"));
 }
}
    