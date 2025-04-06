package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectionResponse {
    int id;
    @SerializedName("suite_id")
    int suiteId;
    String name;
    String description;
}