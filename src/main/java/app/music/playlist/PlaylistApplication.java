package app.music.playlist;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class PlaylistApplication {

    public static void main(String[] args) {

        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIA4LVQADRPAYZCVMH4",
                "2+FzOiCIWTYH5stOGx5KkxwMZLMSZOHa0w4/jHYP"
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        try {
            List<Bucket> buckets = s3client.listBuckets();
            for(Bucket bucket : buckets) {
                System.out.println(bucket.getName());
            }


            ObjectListing objectListing = s3client.listObjects("springboot-app-playlist-music");
            for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
                System.out.println("File name: " + os.getKey());
                S3Object s3object = s3client.getObject("springboot-app-playlist-music", os.getKey());

                System.out.println("File: " + s3client.getUrl("springboot-app-playlist-music", s3object.getKey()));
            }

            s3client.putObject("springboot-app-playlist-music", "cict.png", new File("C:/Users/erika/Desktop/tarpaulin/CICT.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }






        SpringApplication.run(PlaylistApplication.class, args);
    }

}
