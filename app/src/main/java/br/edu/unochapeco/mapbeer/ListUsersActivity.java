package br.edu.unochapeco.mapbeer;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.edu.unochapeco.mapbeer.adapter.ListUsersAdapter;
import br.edu.unochapeco.mapbeer.model.dao.UserDAO;
import br.edu.unochapeco.mapbeer.model.vo.UserVO;

@SuppressLint("Registered")
public class ListUsersActivity extends ListActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//TODO needs to create view
        getListUsers();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        //TODO Could create an logic here
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        //TODO Could create an logic here
        return super.onOptionsItemSelected(item);
    }

    public void getListUsers(){
        final UserDAO userDAO = new UserDAO(this);
        final List<UserVO> listUsers = userDAO.retriveAll();
        final ListUsersAdapter adapter = new ListUsersAdapter(this, R.layout.activity_main /*TODO needs to create view*/, listUsers);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
        //TODO Could create an logic here
    }


}
