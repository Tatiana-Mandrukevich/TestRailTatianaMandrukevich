package entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class Sections {
    ArrayList<Section> sections;
}