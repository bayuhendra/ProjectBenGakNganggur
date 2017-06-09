package com.bitozen.training.common.zul;

import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class CommonViewModel {

    public static final int PAGE_SIZE = 10;
    public static final String PLEASE_SELECT = "-- Please Select --";

    public static void showInformationMessagebox(String message) {
        Messagebox.show(message, Labels.getLabel("common.title.information"), Messagebox.OK, Messagebox.INFORMATION);
    }

    public static void showInformationMessagebox(String message, final String url, final Map<String, Object> param, final Component window) {
        Messagebox.show(message, Labels.getLabel("common.title.information"), Messagebox.OK, Messagebox.INFORMATION, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                if (event.getData().equals(Messagebox.OK)) {
                    navigateTo(url, window, param);
                }
            }
        });
    }

    public static void showErrorMessagebox(String message) {
        Messagebox.show(message, Labels.getLabel("common.title.error"), Messagebox.OK, Messagebox.ERROR);
    }

    public static void showQuestionMessagebox(String message, EventListener<Event> listener) {
        Messagebox.show(message, Labels.getLabel("common.title.question"),
                Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, listener);
    }

    public static Component navigateTo(String targetPage, Component window, Map<String, Object> arg) {
        Component component = Executions.createComponents(targetPage, window.getParent(), arg);
        window.detach();
        return component;
    }

    public static void navigateToWithoutDetach(String targetPage, Component window, Map<String, Object> arg) {
        Window winIdentificationUpdate = (Window) Executions.createComponents(targetPage, window.getParent(), arg);
        winIdentificationUpdate.doModal();
    }

    public static Component navigateTopPopUp(String targetPage, Component window, Map<String, Object> arg) {
        Component component = Executions.createComponents(targetPage, window, arg);
        return component;
    }

    public static void goToGlobalCommandCloseTab() {
        BindUtils.postGlobalCommand(null, null, "closeTab", null);
    }

    public static void onCloseTab() {
        showQuestionMessagebox(Labels.getLabel("common.question.close"), new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                if (event.getData().equals(Messagebox.OK)) {
                    goToGlobalCommandCloseTab();
                }
            }
        });
    }

//    public static ResponseEntity restServiceExchange(Modul modul, String url, HttpMethod httpMethod, HttpEntity request, Class c, Object... varargs) {
//        if (httpMethod.equals(HttpMethod.POST) || httpMethod.equals(HttpMethod.PUT)) {
//            c = null;
//        }
//        return new RestTemplate().exchange(modul.getUrl() + url, httpMethod, request, c, varargs);
//    }

//    public static void viewReport(String reportName, GenerateReport generateReport, Window window, Object... varargs) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("reportName", reportName);
//        params.put("generateReport", generateReport);
//        params.put("varargs", varargs);
//        Executions.createComponents("/zul/report/report_view.zul", window, params);
//    }
}
