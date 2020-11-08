package com.demo.apicrud;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.apicrud.Models.GetUserDetails.ResponseUserDetail;
import com.demo.apicrud.Models.GetUsers.Demo;
import com.demo.apicrud.Models.GetUsers.ResponseUsers;
import com.demo.apicrud.Models.ResponseCommon;
import com.demo.apicrud.webapi.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Context context;

    EditText editTextName,editTextContact,editTextCity;
    ArrayList<Demo> arrayListUsers;
    AdapterCommonSelection adapterCommonSelection;
    RecyclerView recyclerviewUsers;
    Button buttonSubmit,buttonCancelUpdate;

    public String selectedId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        init();
    }

    public void init() {

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextContact = (EditText) findViewById(R.id.editTextContact);
        editTextCity = (EditText) findViewById(R.id.editTextCity);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonCancelUpdate = (Button) findViewById(R.id.buttonCancelUpdate);

        recyclerviewUsers = (RecyclerView) findViewById(R.id.recyclerviewUsers);
        recyclerviewUsers.setLayoutManager(new LinearLayoutManager(context));

        arrayListUsers = new ArrayList<>();
        adapterCommonSelection = new AdapterCommonSelection(this, arrayListUsers);

        recyclerviewUsers.setAdapter(adapterCommonSelection);


        buttonSubmit.setOnClickListener(v -> {
          if(editTextName.getText().toString().equals("")){
              showToast("Enter Name");
          }else if(editTextContact.getText().toString().equals("")){
              showToast("Enter contact");
          }else if(editTextCity.getText().toString().equals("")){
              showToast("Enter city");
          }else{
              if(!selectedId.equals("")){
                  updateUser(selectedId,editTextName.getText().toString(),editTextContact.getText().toString(),editTextCity.getText().toString());
              }else{
                  addUser(editTextName.getText().toString(),editTextContact.getText().toString(),editTextCity.getText().toString());
              }
          }
        });
        buttonCancelUpdate.setOnClickListener(v -> {
            selectedId = "";
            editTextName.setText("");
            editTextContact.setText("");
            editTextCity.setText("");
            buttonCancelUpdate.setVisibility(View.GONE);
        });
        getUsers();
    }

    public void getUsers() {


        showToast("Getting users");
        Call<ResponseUsers> call = ApiClient.getClient().getUsers();
        call.enqueue(new Callback<ResponseUsers>() {
            @Override
            public void onResponse(Call<ResponseUsers> call, Response<ResponseUsers> response) {
                if (response.code() == 200) {

                    arrayListUsers.clear();
                    arrayListUsers.addAll(response.body().getDemos());
                    adapterCommonSelection.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseUsers> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public void getUserDetails(String id) {
        selectedId = id;
        showToast("Getting selected user details");
        Call<ResponseUserDetail> call = ApiClient.getClient().getUserDetails(ApiClient.BASE_URL+"demos/show/"+ id);
        call.enqueue(new Callback<ResponseUserDetail>() {
            @Override
            public void onResponse(Call<ResponseUserDetail> call, Response<ResponseUserDetail> response) {
                if (response.code() == 200 && response.body().getDemo() != null) {
                    buttonCancelUpdate.setVisibility(View.VISIBLE);
                    editTextName.setText(response.body().getDemo().getName());
                    editTextContact.setText(response.body().getDemo().getContact());
                    editTextCity.setText(response.body().getDemo().getCity());

                }
            }

            @Override
            public void onFailure(Call<ResponseUserDetail> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public void addUser(String name, String contact, String city) {

        showToast("Adding user");
        Call<ResponseCommon> call = ApiClient.getClient().addUser(name, contact, city,"temp");
        call.enqueue(new Callback<ResponseCommon>() {
            @Override
            public void onResponse(Call<ResponseCommon> call, Response<ResponseCommon> response) {
                if (response.code() == 200) {
                    showToast("User Added Successfully");
                    getUsers();
                }
            }

            @Override
            public void onFailure(Call<ResponseCommon> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public void updateUser(String id, String name, String contact, String city) {

        showToast("Updating user");
        Call<ResponseCommon> call = ApiClient.getClient().updateUser(ApiClient.BASE_URL+"demos/update/"+id, name, contact, city);
        call.enqueue(new Callback<ResponseCommon>() {
            @Override
            public void onResponse(Call<ResponseCommon> call, Response<ResponseCommon> response) {
                if (response.code() == 200) {
                    showToast("User Updated Successfully");
                    getUsers();
                }
            }

            @Override
            public void onFailure(Call<ResponseCommon> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    public void deleteUser(String id) {
        showToast("Deleting user");
        Call<ResponseCommon> call = ApiClient.getClient().deleteUser(ApiClient.BASE_URL+"demos/destroy/"+id, "DELETE");
        call.enqueue(new Callback<ResponseCommon>() {
            @Override
            public void onResponse(Call<ResponseCommon> call, Response<ResponseCommon> response) {
                if (response.code() == 200) {
                    getUsers();
                    showToast("User Deleted Successfully");
                }
            }

            @Override
            public void onFailure(Call<ResponseCommon> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}