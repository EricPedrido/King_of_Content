package model;

import javafx.scene.image.ImageView;

public class Purchasable {
    private int _purchasePrice;
    private int _landingCost;
    private Player _owner;
    private ImageView _cardImage;

    public Purchasable(int purchasePrice, int landingCost, ImageView image) {
        _purchasePrice = purchasePrice;
        _landingCost = landingCost;
        _cardImage = image;
    }

    public void setOwner(Player player) {
        _owner = player;
    }
}
