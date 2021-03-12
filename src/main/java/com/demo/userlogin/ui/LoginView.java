package com.demo.userlogin.ui;

import com.demo.userlogin.cotroller.UserController;
import com.demo.userlogin.model.User;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

@Route("login")
public class LoginView extends Dialog {

    public LoginView() {
        super();

        UserController userController = new UserController();
        EmailField emailField = new EmailField("Email", "Your email");
        PasswordField passwordField = new PasswordField("Password", "Your password");
        Button loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addClickShortcut(Key.ENTER);
        Label statusLabel = new Label();

        loginButton.addClickListener(event -> {

            String email = emailField.getValue();
            String password = passwordField.getValue();

            List <User>userList = userController.findAllUsers();

            boolean chk = true;
            for(User user : userList){
                if(user.getEmail().equals(email.toLowerCase()) && user.getPassword().equals(password)){
                    loginButton.getUI().ifPresent(ui -> ui.navigate("landing"));
                    chk = false;
                    break;
                }
            }

            if(chk){
                statusLabel.setText("Wrong email or password");
            }
        });

        FormLayout formLayout = new FormLayout();
        formLayout.add(emailField, passwordField, loginButton, statusLabel);
        add(formLayout);

        setWidth("500px");

        open();
    }
}