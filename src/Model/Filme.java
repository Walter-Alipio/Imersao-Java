package Model;

public class Filme {
   private  String original_title;
   private String title;

   private String release_date;
   private Double vote_average;
   private String poster_path;

    public String getOriginal_title()
   {
       return original_title;
   }
    public void  setOriginal_title(String original_title)
    {
        this.original_title = original_title;
    }
    public  String getTitle(){
       return title;
    }
    public void setTitle(String title){
       this.title = title;
    }
    public String getRelease_date(){
      return release_date;
    }

   public void setRelease_date(String release_date) {
      this.release_date = release_date;
   }

   public Double getVote_average() {
      return vote_average;
   }

   public void setVote_average(Double vote_average) {
      this.vote_average = vote_average;
   }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}

//{"adult":false,"backdrop_path":"/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
// "genre_ids":[18,80],"id":238,
// "original_language":"en",
// "popularity":104.008,
// "poster_path":"/oJagOzBu9Rdd9BrciseCm3U3MCU.jpg",

