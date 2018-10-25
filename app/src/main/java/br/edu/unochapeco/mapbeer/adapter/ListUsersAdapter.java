package br.edu.unochapeco.mapbeer.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.unochapeco.mapbeer.R;
import br.edu.unochapeco.mapbeer.model.vo.UserVO;

import static android.content.Context.*;

public class ListUsersAdapter extends ArrayAdapter<UserVO> {

    private List<UserVO> listUsers;
    private LayoutInflater inflater;

    public ListUsersAdapter(final Context context, final int resource, final List<UserVO> objects) {
        super(context, resource, objects);
        this.listUsers = objects;
        this.inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        // TODO needs to create views
        @SuppressLint({"InflateParams", "ViewHolder"})
        final View item = inflater.inflate(R.layout.activity_main, null);
        final UserVO user = listUsers.get(position);
        @SuppressLint("CutPasteId")
        final TextView label = item.findViewById(R.id.action_settings);

        label.setText(user.getName());

        return item;
    }
}


