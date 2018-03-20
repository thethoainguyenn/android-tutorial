package com.example.thoailun.androidtutorial;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * AsyncTask quản lý tiến trình khi thực hiện lấy dữ liệu ở môi trường mạng
 * */

public class AnsyncTaskDemoActivity extends AppCompatActivity {
    Button btnXuLy;
    TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ansync_task_demo);
        btnXuLy = (Button) findViewById(R.id.btnXyLy);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CongViec().execute();
            }
        });
    }
    // Tham số - quá trình xử lý trả về tham số kiểu gì - kết quả trả ra kiểu gì
    private  class  CongViec extends AsyncTask<Void, String, String> {
        // Trước khi chạy
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtInfo.setText("Bắt đầu" + "\n");
        }

        // Trong quá trình chạy
        @Override
        protected String doInBackground(Void... voids) {
            for(int i=0; i< 5; i++) {
                // Gọi hàm update bên dưới, hàm này chạy trong lúc doInBackground chạy
                // Muốn cập nhật trong quá trình xử lý thì gọi onProgressUpdate, còn không thì khỏi
                // Hàm này không được tác động giao diện vào
                publishProgress("Xong rồi" + i);
            }
            return "Xong rồi";
        }

        // Sau khi thực hiện xong doInbackground nhận về
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtInfo.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtInfo.append(values[0]);
        }
    }
}
