package todo;

public class Todo {
    private String title;        //Todo項目のタイトルを格納するための文字列型のフィールド
    private boolean completed;   //Todo項目が完了しているかどうかを示す真偽値型のフィールド
                                 //true なら完了、false なら未完了
    public Todo(String title) {  //コンストラクタで、Todo オブジェクトを作成する際にタイトルを指定
        this.title = title;      //引数として渡された title をクラスのフィールド title に代入
        this.completed = false;  //Todo項目が新しく作成されたときは未完了であるためcompleted を false に設定
    }

    public String getTitle() {   //Todo項目のタイトルを取得するためのメソッド
        return title;
    }

    public boolean isCompleted() {//Todo項目が完了しているかどうかを取得するためのメソッド
        return completed;
    }

    public void setTitle(String title) {//Todo項目のタイトルを設定するためのメソッド
        this.title = title;
    }

    public void setCompleted(boolean completed) {//Todo項目の完了状態を設定するためのメソッド
        this.completed = completed;
    }

    @Override  //親クラス（この場合は Object クラス）のメソッドをオーバーライド
    public String toString() {//Todo項目の文字列表現を返す
        return (completed ? "[完了] " : "[未完了] ") + title;
    }//完了している場合は "[完了] " を、未完了の場合は "[未完了] " をタイトルの前に付けて返す
}
