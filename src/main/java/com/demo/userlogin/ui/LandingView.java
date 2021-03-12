package com.demo.userlogin.ui;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("landing")
public class LandingView extends Dialog {

    public LandingView(){
        VerticalLayout layout = new VerticalLayout();

        Label label = new Label("Labeling can be dangerous");
        layout.add(label);
        add(layout);

        setWidth("300px");

        open();
    }

}