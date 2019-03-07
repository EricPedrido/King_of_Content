package model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Idea extends Purchasable {
    private List<Integer> _stages;

    public Idea() {
        this(0,0,0,0,0,0,null);
    }

    public Idea (int purchasePrice, int landCost, int stage1, int stage2, int stage3, int stage4, ImageView image) {
        super(purchasePrice, landCost, image);
        _stages = new ArrayList<>(Arrays.asList(stage1, stage2, stage3, stage4));
    }
}
