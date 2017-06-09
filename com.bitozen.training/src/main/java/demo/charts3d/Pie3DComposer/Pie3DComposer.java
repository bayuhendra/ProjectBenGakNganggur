//package demo.charts3d.Pie3DComposer;
//
//import java.awt.Point;
//import org.springframework.http.HttpStatus.Series;
//import org.zkoss.chart.Charts;
//import org.zkoss.chart.options3D.Options3D;
//import org.zkoss.chart.plotOptions.DataLabels;
//import org.zkoss.chart.plotOptions.PiePlotOptions;
//import org.zkoss.zk.ui.select.SelectorComposer;
//import org.zkoss.zk.ui.select.annotation.Wire;
//import org.zkoss.zul.Window;
//
//
//public class Pie3DComposer extends SelectorComposer<Window> {
//
//    @Wire
//    Charts chart;
//    
//    public void doAfterCompose(Window comp) throws Exception {
//        super.doAfterCompose(comp);
//        
//        Options3D opt3d = chart.getOptions3D();
//        opt3d.setEnabled(true);
//        opt3d.setAlpha(45);
//        opt3d.setBeta(0);
//        chart.getTooltip().setPointFormat("{series.name}: <b>{point.percentage:.1f}%</b>");
//        PiePlotOptions pot = chart.getPlotOptions().getPie();
//        pot.setAllowPointSelect(true);
//        pot.setCursor("pointer");
//        pot.setDepth(35);
//        
//        DataLabels dls = pot.getDataLabels();
//        dls.setEnabled(true);
//        dls.setFormat("{point.name}");
//        
//        initSeries();
//    }
//    
//    private void initSeries() {
//        Series series = chart.getSeries();
//        series.setType("pie");
//        series.setName("Browser share");
//        series.addPoint(new Point("Firefox", 45.0));
//        series.addPoint(new Point("IE", 26.8));
//        Point chrome = new Point("Chrome", 12.8);
//        chrome.setSelected(true);
//        chrome.setSliced(true);
//        series.addPoint(chrome);
//        series.addPoint(new Point("Safari", 8.5));
//        series.addPoint(new Point("Opera", 6.2));
//        series.addPoint(new Point("Others", 0.7));
//    }
//}