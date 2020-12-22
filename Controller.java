package sample;


import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
    @FXML
    private Label howManyTry;
    @FXML

    private TextField YourText;

    @FXML
    private Label rightOrNo;

    @FXML
//    ввод данных
    void tryYourGuess() {
        int Try = 0;
        String yourNumber = YourText.getText();
        YourText.clear();
        Random random = new Random();
//проверка ответа
        do {

            int trueNumber = random.nextInt((10) + 1);
            if (trueNumber == Integer.parseInt(yourNumber)) {
                Try++;
                rightOrNo.setText("вы угадали");


            } else {


                if (trueNumber != Integer.parseInt(yourNumber)) {
                    Try++;
                    rightOrNo.setText("вы не угадали");
                    if (trueNumber > Integer.parseInt(yourNumber)) {
                        rightOrNo.setText("нужное число больше");

                    }
                    if (trueNumber < Integer.parseInt(yourNumber)) {
                        rightOrNo.setText("нужное число меньше");

                    }


                }

            }
            howManyTry.setText("колличество попыток" + Try);
        }
        while (Try < 3);
//информация о числе попыток


    }

    //    закрытие приложения
    @FXML
    void CloseApp() {
        System.exit(1);
    }

}









