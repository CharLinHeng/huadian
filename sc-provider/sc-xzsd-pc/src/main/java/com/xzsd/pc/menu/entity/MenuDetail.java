package com.xzsd.pc.menu.entity;

public class MenuDetail {
    /**
     *菜单编号
     */
    private String menuCode;
    /**
     *菜单名
     */
    private String menuName;
    /**
     *菜单路由
     */
    private String menuRoute;
    /**
     *是否菜单
     */
    private String menuIsMenu;
    /**
     * 菜单备注
     */
    private String menuRemark;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuRoute() {
        return menuRoute;
    }

    public void setMenuRoute(String menuRoute) {
        this.menuRoute = menuRoute;
    }

    public String getMenuIsMenu() {
        return menuIsMenu;
    }

    public void setMenuIsMenu(String menuIsMenu) {
        this.menuIsMenu = menuIsMenu;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }
}
