package todo;
//アプリ全体の流れを制御する。メニューの表示、入力の受付、処理の実行。

import java.util.ArrayList;//可変長の配列を使用可能
import java.util.Scanner; //ユーザーからの入力を受け取るためのクラス

public class Main {
    public static void main(String[] args) {
        ArrayList<Todo> todoList = new ArrayList<>();//Todo オブジェクトを格納するための空のリストを作成
        Scanner scanner = new Scanner(System.in);//標準入力からデータを読み取るためのScannerオブジェクトを作成

        while (true) {//無限ループを開始
            //アプリケーションのメニューを表示
            System.out.println("\n==== ToDoアプリ ====");
            System.out.println("1. 一覧表示");
            System.out.println("2. ToDoを追加");//機能追加
            System.out.println("3. ToDoを削除");//削除機能
            System.out.println("0. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();//ユーザーの選択を整数として取得
            scanner.nextLine();            // 改行を読み飛ばす

            //ユーザーの選択に応じた処理
            //一覧表示
            if (choice == 1) {
                System.out.println("=== ToDo一覧 ===");
                if (todoList.isEmpty()) {
                    System.out.println("ToDoはまだありません。");
                } else {
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ": " + todoList.get(i));
                    }
                }
             //追加機能
            } else if (choice == 2) {
                System.out.print("ToDoのタイトルを入力してください: ");
                String title = scanner.nextLine();
                Todo newTodo = new Todo(title);
                todoList.add(newTodo);
                System.out.println("ToDoを追加しました。");
             //削除機能
            } else if (choice == 3) {
                if (todoList.isEmpty()) {
                    System.out.println("ToDoはまだありません。");
                } else {
                    System.out.println("=== ToDo一覧 ===");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ": " + todoList.get(i));
                    }

                    System.out.print("削除するToDoの番号を入力してください: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // 改行を読み飛ばす

                    if (index >= 1 && index <= todoList.size()) {
                        Todo removed = todoList.remove(index - 1);
                        System.out.println("ToDo「" + removed.getTitle() + "」を削除しました。");
                    } else {
                        System.out.println("無効な番号です。");
                    }
                }
            } else if (choice == 0) {
                System.out.println("終了します。");
                break;
            } else {
                System.out.println("無効な選択です。");
            }
        }

        scanner.close(); // whileの外に移動
    }//使っていたscannerクラスを解放
}
