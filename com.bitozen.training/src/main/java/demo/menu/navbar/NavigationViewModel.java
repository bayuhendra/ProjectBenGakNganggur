package demo.menu.navbar;

import java.util.LinkedHashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

public class NavigationViewModel {

    private String src = "/home/about_us.zul";

    NavigationPage currentPage;
    private Map<String, Map<String, NavigationPage>> pageMap;

    @Init
    public void init() {
        initPageMap();
        currentPage = pageMap.get("Dashboard").get("About Us");
    }

    @Command
    public void navigatePage(@BindingParam("target") NavigationPage targetPage) {
        BindUtils.postNotifyChange(null, null, currentPage, "selected");
        currentPage = targetPage;
        BindUtils.postNotifyChange(null, null, this, "currentPage");
    }

    public NavigationPage getCurrentPage() {
        return currentPage;
    }

    public Map<String, Map<String, NavigationPage>> getPageMap() {
        return pageMap;
    }

    private void initPageMap() {
        pageMap = new LinkedHashMap<String, Map<String, NavigationPage>>();

        addPage("Dashboard", "Dashboard App Point Of Sale", "/home/dashboard.zul");
//        addPage("Dashboard", "Reports", "/home/menu.zul");
//        addPage("Dashboard", "FAQ", "/home/faq.zul");

        addPage("Master Data", "Data Pelangan", "/customers/data_pelangan.zul", "active");
        addPage("Master Data", "Data Pemasok", "/customers/data_pemasok.zul", "inactive");
        addPage("Master Data", "Data Barang", "/customers/data_barang.zul", "inactive");

        addPage("Transakasi", "In Preparation", "/transaksi/orders.zul", "in-preparation");
        addPage("Transakasi", "Ready for Shipping", "/transaksi/orders.zul", "ready");
        addPage("Transakasi", "Shipping", "/transaksi/orders.zul", "shipping");
        addPage("Transakasi", "Specified for Later", "/transaksi/orders.zul", "later");

        addPage("Laporan", "Events", "/fan_service/events.zul");
        addPage("Laporan", "Promotion", "/fan_service/promotion.zul");
    }

    private void addPage(String title, String subTitle, String includeUri) {
        addPage(title, subTitle, includeUri, null);
    }

    private void addPage(String title, String subTitle, String includeUri, String data) {
        String folder = "/projectku/menu";
        Map<String, NavigationPage> subPageMap = pageMap.get(title);
        if (subPageMap == null) {
            subPageMap = new LinkedHashMap<String, NavigationPage>();
            pageMap.put(title, subPageMap);
        }
        NavigationPage navigationPage = new NavigationPage(title, subTitle,
                folder + includeUri + "?random=" + Math.random(), data) {
            @Override
            public boolean isSelected() {
                return currentPage == this;
            }
        };
        subPageMap.put(subTitle, navigationPage);
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
