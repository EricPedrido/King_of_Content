package model;

import model.tiles.DirectEffectTile;
import model.tiles.PaneLoadTile;
import model.tiles.Tile;

import static model.BoardPane.*;
import static model.tiles.Pane.*;

public enum Board {//TODO lane view needs a SECOND view for when it is on the corners.

    UPLOAD(new DirectEffectTile(835, 465, 982,610, SIDE_1, 10000, 50000)),
    GREEN_1(new PaneLoadTile(843, 423, 348, 636, SIDE_2, PURCHASABLE)),
    FAN_MAIL_1(new PaneLoadTile(832,386, 415, 620, SIDE_2, FAN_MAIL)),
    GREEN_2(new PaneLoadTile(843,349, 484, 636, SIDE_2, PURCHASABLE)),
    DEMONETISED(new DirectEffectTile(825, 310, 551, 607, SIDE_2, -10000, 0)),
    BRAND_DEAL_1(new DirectEffectTile(821, 272, 618, 607, SIDE_2)),
    ORANGE_1(new PaneLoadTile(844, 233, 685, 640, SIDE_2, PURCHASABLE)),
    RISK_1(new PaneLoadTile(829, 196, 753, 615, SIDE_2, RISK)),
    ORANGE_2(new PaneLoadTile(843, 159, 821, 640, SIDE_2, PURCHASABLE)),
    ORANGE_3(new PaneLoadTile(843, 119, 888, 640, SIDE_2, PURCHASABLE)),
    MEDIA_STORM_VISIT(new PaneLoadTile(853, 47, 1018, 660, SIDE_2, TEMP)), // TODO a "do nothing" turn
    CYAN_1(new PaneLoadTile(782, 57, 348, 640, SIDE_3, PURCHASABLE)),
    COLLAB_1(new PaneLoadTile(744, 80, 415, 600, SIDE_3, PURCHASABLE)),
    CYAN_2(new PaneLoadTile(705, 57, 484, 640, SIDE_3, PURCHASABLE)),
    CYAN_3(new PaneLoadTile(667, 57, 551, 640, SIDE_3, PURCHASABLE)),
    BRAND_DEAL_2(new DirectEffectTile(631, 79, 618, 600, SIDE_3)),
    PINK_1(new PaneLoadTile(592, 58, 685, 640, SIDE_3, PURCHASABLE)),
    FAN_MAIL_2(new PaneLoadTile(554, 71, 753, 615, SIDE_3, FAN_MAIL)),
    PINK_2(new PaneLoadTile(515,58, 821, 640, SIDE_3, PURCHASABLE)),
    PINK_3(new PaneLoadTile(478, 58, 888, 640, SIDE_3, PURCHASABLE)),
    CONT_CON_TILE(new PaneLoadTile(431, 72, 970, 613, SIDE_3, CONT_CON)),
    YELLOW_1(new PaneLoadTile(415, 119, 348, 640, SIDE_4, PURCHASABLE)),
    RISK_2(new PaneLoadTile(430, 156, 415, 610, SIDE_4, RISK)),
    YELLOW_2(new PaneLoadTile(416, 194, 484, 640, SIDE_4, PURCHASABLE)),
    YELLOW_3(new PaneLoadTile(416, 233, 551, 640, SIDE_4, PURCHASABLE)),
    BRAND_DEAL_3(new DirectEffectTile(437, 270, 618, 600, SIDE_4)),
    PURPLE_1(new PaneLoadTile(416,  309, 685, 640, SIDE_4, PURCHASABLE)),
    PURPLE_2(new PaneLoadTile(416, 348, 753, 640, SIDE_4, PURCHASABLE)),
    COLLAB_2(new PaneLoadTile(438, 386, 821, 600, SIDE_4, PURCHASABLE)),
    PURPLE_3(new PaneLoadTile(416, 424, 888, 640, SIDE_4, PURCHASABLE)),
    CONTROVERSY(new Tile(434, 468, 975, 610, SIDE_4) {
        @Override
        public void onLand(Player player) {
            player.setPosition(getX(), getY());
        }
    }),
    BLUE_1(new PaneLoadTile(477, 485, 348, 640, SIDE_1, PURCHASABLE)),
    BLUE_2(new PaneLoadTile(515, 485, 415, 640, SIDE_1, PURCHASABLE)),
    FAN_MAIL_3(new PaneLoadTile(553, 473, 484, 620, SIDE_1, FAN_MAIL)),
    BLUE_3(new PaneLoadTile(591, 485, 551, 640, SIDE_1, PURCHASABLE)),
    BRAND_DEAL_4(new DirectEffectTile(629, 464, 618, 600, SIDE_1)),
    RISK_3(new PaneLoadTile(667, 470, 685, 615, SIDE_1, RISK)),
    RED_1(new PaneLoadTile(706, 485, 753, 640, SIDE_1, PURCHASABLE)),
    BACK_LASH(new DirectEffectTile(744, 463, 821, 600, SIDE_1, -5000, -25000)),
    RED_3(new PaneLoadTile(781, 485, 888, 640, SIDE_1, PURCHASABLE)),
    MEDIA_STORM_ENTER(new PaneLoadTile(825, 77, 970, 610, SIDE_2, MEDIA_STORM));

    private Tile _tile;

    Board(Tile tile) {
        _tile = tile;
    }

//    public void onLand(Player player) {
//        _tile.onLand(player);
//    }

//    public int getX() {
//        return _tile.getX();
//    }
//
//    public int getY() {
//        return _tile.getY();
//    }
//
//    public int getPaneX() {
//        return _tile.getPaneX();
//    }
//
//    public int getPaneY() {
//        return _tile.getPaneY();
//    }

    public Tile getTile() {
        return _tile;
    }
}