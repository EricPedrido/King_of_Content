package model;

import model.tiles.*;

import static model.tiles.Pane.*;

public enum Board {

    UPLOAD(new DirectEffectTile(835, 465, 10000, 50000)),
    GREEN_1(new PaneLoadTile(843, 423, PURCHASABLE)),
    FAN_MAIL_1(new PaneLoadTile(832,386, FAN_MAIL)),
    GREEN_2(new PaneLoadTile(843,349, PURCHASABLE)),
    DEMONETISED(new DirectEffectTile(825, 310, -10000, 0)),
    BRAND_DEAL_1(new DirectEffectTile(821, 272)),
    ORANGE_1(new PaneLoadTile(844, 233, PURCHASABLE)),
    RISK_1(new PaneLoadTile(829, 196, RISK)),
    ORANGE_2(new PaneLoadTile(843, 159, PURCHASABLE)),
    ORANGE_3(new PaneLoadTile(843, 119, PURCHASABLE)),
    MEDIA_STORM_VISIT(new PaneLoadTile(853, 47, TEMP)), // TODO a "do nothing" turn
    CYAN_1(new PaneLoadTile(782, 57, PURCHASABLE)),
    COLLAB_1(new PaneLoadTile(744, 80, PURCHASABLE)),
    CYAN_2(new PaneLoadTile(705, 57, PURCHASABLE)),
    CYAN_3(new PaneLoadTile(667, 57, PURCHASABLE)),
    BRAND_DEAL_2(new DirectEffectTile(631, 79)),
    PINK_1(new PaneLoadTile(592, 58, PURCHASABLE)),
    FAN_MAIL_2(new PaneLoadTile(554, 71, FAN_MAIL)),
    PINK_2(new PaneLoadTile(515,58, PURCHASABLE)),
    PINK_3(new PaneLoadTile(578, 58, PURCHASABLE)),
    CONT_CON_TILE(new PaneLoadTile(431, 72, CONT_CON)),
    YELLOW_1(new PaneLoadTile(415, 119, PURCHASABLE)),
    RISK_2(new PaneLoadTile(430, 156, RISK)),
    YELLOW_2(new PaneLoadTile(416, 194, PURCHASABLE)),
    YELLOW_3(new PaneLoadTile(416, 233, PURCHASABLE)),
    BRAND_DEAL_3(new DirectEffectTile(437, 270)),
    PURPLE_1(new PaneLoadTile(416,  309, PURCHASABLE)),
    PURPLE_2(new PaneLoadTile(416, 348, PURCHASABLE)),
    COLLAB_2(new PaneLoadTile(438, 386, PURCHASABLE)),
    PURPLE_3(new PaneLoadTile(416, 424, PURCHASABLE)),
    CONTROVERSY(new Tile(434, 468) {
        @Override
        public void onLand(Player player) {
            player.setPosition(getX(), getY());
        }
    }),
    BLUE_1(new PaneLoadTile(477, 485, PURCHASABLE)),
    BLUE_2(new PaneLoadTile(515, 485, PURCHASABLE)),
    FAN_MAIL_3(new PaneLoadTile(553, 473, FAN_MAIL)),
    BLUE_3(new PaneLoadTile(591, 485, PURCHASABLE)),
    BRAND_DEAL_4(new DirectEffectTile(629, 464)),
    RISK_3(new PaneLoadTile(667, 470, RISK)),
    RED_1(new PaneLoadTile(706, 485, PURCHASABLE)),
    BACK_LASH(new DirectEffectTile(744, 463, -5000, -25000)),
    RED_3(new PaneLoadTile(781, 485, PURCHASABLE)),
    MEDIA_STORM_ENTER(new PaneLoadTile(825, 77, MEDIA_STORM));

    private Tile _tile;

    Board(Tile tile) {
        _tile = tile;
    }

    public int getX() {
        return _tile.getX();
    }

    public int getY() {
        return _tile.getY();
    }
}