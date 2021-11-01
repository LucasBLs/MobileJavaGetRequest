package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    Button mButton;
    EditText user;
    EditText password;

    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] textBytes = text.getBytes("iso-8859-1");
        md.update(textBytes, 0, textBytes.length);
        byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        textViewResult = findViewById(R.id.ReturnById);
        OkHttpClient client = new OkHttpClient();
=======
        textViewResult = findViewById(R.id.text_view_result);
        //OkHttpClient client = new OkHttpClient();

>>>>>>> d542f5acdea3f6d3f85d603a0df726175e7ae9c3
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://177.70.244.192:14245/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Item>> call = jsonPlaceHolderApi.getItens();

        call.enqueue(new Callback<List<Item>>() {
            @Override
<<<<<<< HEAD
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (!response.isSuccessful()) {
=======
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(!response.isSuccessful())
                {
>>>>>>> d542f5acdea3f6d3f85d603a0df726175e7ae9c3
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

<<<<<<< HEAD
                List<Cliente> clientes = response.body();
                mButton = (Button) findViewById(R.id.btnlogin);
                user = (EditText) findViewById(R.id.txtnomelogin);
                password = (EditText) findViewById(R.id.txtsenhalogin);

                mButton.setOnClickListener(
                        new View.OnClickListener() {
                            public void onClick(View view) {
                                String usuario = user.getText().toString();
                                String senha = password.getText().toString();
=======
                List<Item> itens = response.body();

                for (Item item : itens)
                {
                    String content = "";
                    content += "NÚMERO: " + item.getNr_item() + "\n";
                    content += "EAN: " + item.getEan_item() + "\n";
                    content += "DESCRIÇÃO: " + item.getDesc_item() + "\n";
                    content += "QUANTIDADE: " + item.getQuantidade() + "\n";
                    content += "VALOR: " + item.getValor() + "\n";
                    content += "SITUAÇÃO: " + item.getSituacao() + "\n";
>>>>>>> d542f5acdea3f6d3f85d603a0df726175e7ae9c3

                                try {
                                    senha = SHA1(senha);
                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace(); //40bd001563085fc35165329ea1ff5c5ecbdbbeef
                                }

                                for (Cliente cliente : clientes) {
                                    if (usuario.equals(cliente.getUsuario()) && senha.equals(cliente.getSenha()) && cliente.getStatus_del_lgo().equals("V")) {
                                        String content = "";
                                        content += "ID: " + cliente.getCod_clnt() + "\n";
                                        content += "User ID: " + cliente.getUsuario() + "\n";
                                        content += "Password: " + cliente.getSenha() + "\n";
                                        int cont = 1;
                                        textViewResult.append(content);
                                    }
                                } //
                            }
                        });
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}

//byte[] senha = senha.getBytes(StandardCharsets.US_ASCII);
//String a = getHashMd5(new String(b));
//byte[] encodedBytes = Base64.getEncoder().encode(new String(getHashMd5(new String(b))).getBytes());
//Charset utf16 = Charset.forName("UTF-16LE");
//return new String(Base64.getEncoder(DigestUtils.md5(new String().getBytes(utf16))));