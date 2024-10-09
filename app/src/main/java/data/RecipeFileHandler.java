package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        // レシピデータの読み込み
        // 変数、配列の宣言
        String line;
        ArrayList<String> array = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while((line = reader.readLine()) != null){
                array.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: 例外のメッセージ");
        }
        return array;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        // レシピデータの書き込み
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            //レシピ名と材料をカンマ区切りで1行にする
            String write = String.join(",", recipeName, ingredients);
            //改行して書き込み
            writer.newLine();
            writer.write(write);
        // 例外のメッセージ
        } catch (IOException e) {
            System.out.println("Error reading file: 例外のメッセージ");
        }
    }
}
