package christmas.model;

import christmas.constant.BadgeEnum;

public class Badge {
    private BadgeEnum badge;

    public Badge(int price) {
        this.badge = calculateBadge(price);
    }

    private BadgeEnum calculateBadge(int price) {
        if (price >= BadgeEnum.SANTA.getBadgePrice()) {
            return BadgeEnum.SANTA;
        }
        if (price >= BadgeEnum.TREE.getBadgePrice()) {
            return BadgeEnum.TREE;
        }
        if (price >= BadgeEnum.STAR.getBadgePrice()) {
            return BadgeEnum.STAR;
        }

        return null;
    }

    @Override
    public String toString() {
        return badge != null ? badge.getBadgeName() : "없음";
    }

    public BadgeEnum getBadge() {
        return badge;
    }
}
