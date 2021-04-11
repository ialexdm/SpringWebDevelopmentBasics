package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component("cartController")
public class CartController {

    private int userInput;
    private Cart cart;
    private ProductRepository productRepository;

    public void start(){
        System.out.println("Магазин запущен...");
        setCart(cart);
        showProducts();
        control();




    }


    private void showProducts(){
        System.out.println("Наши товары:");
        productRepository.printProducts();
        System.out.println("Ваша корзина:");
        cart.printCart();
        System.out.print("Введите id товара или [-1] чтобы завершить покупки..");
    }
    private void control(){
        new Thread(() -> {
            try (BufferedReader commandReader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    userInput = Integer.parseInt(commandReader.readLine());
                        int id = userInput;
                        if (userInput == -1){
                            System.out.println("Завершение покупки. [1]оплатить[2]отмена[3]создать новую корзину[4]выход");
                            userInput = Integer.parseInt(commandReader.readLine());
                            if (userInput == 3){
                                cart = new Cart();
                                setCart(cart);
                                showProducts();
                            }
                            if (userInput == 1){
                                cart.putProduct(productRepository,id);
                                System.out.println("Спасибо за покупку!Создать новую корзину?[1]да[2]нет");
                                userInput = Integer.parseInt(commandReader.readLine());
                                if (userInput == 1){
                                    cart = new Cart();
                                    setCart(cart);
                                    showProducts();
                                }
                                if (userInput == 2){
                                    finish();
                                    return;
                                }
                            }
                            if (userInput == 2){
                                showProducts();
                            }
                            if (userInput == 4){
                                finish();
                                return;
                            }
                        }
                        if (cart.getProductById(id)!=null){
                            System.out.println("Товар уже есть в корзине...[1]Добавить[2]Отмена[3]Удалить");
                            userInput = Integer.parseInt(commandReader.readLine());
                            if (userInput == 3){
                                cart.removeProduct(id);
                                showProducts();

                            }
                            if (userInput == 1){
                                cart.putProduct(productRepository,id);
                                showProducts();
                            }
                            if (userInput == 2){
                                showProducts();
                            }
                        }else {
                            if (productRepository.getProductById(id)!= null){
                                System.out.println("Добавить в корзину?...[1]Добавить[2]Отмена");
                                userInput = Integer.parseInt(commandReader.readLine());
                                if (userInput == 1){
                                    cart.putProduct(productRepository,id);
                                    showProducts();
                                }
                                if (userInput == 2){
                                    showProducts();
                                }
                            }
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }).start();

    }

    private void finish(){
        System.out.println("До свидания!");
        System.out.println("Магазин отключен...");
    }



    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
