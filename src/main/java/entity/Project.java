package entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    String name;
    String announcement;
    @SerializedName("show_announcement")
    boolean showAnnouncement;
    @SerializedName("suite_mode")
    int suiteMode;
    int id;
}