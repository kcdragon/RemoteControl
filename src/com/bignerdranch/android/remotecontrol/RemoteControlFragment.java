package com.bignerdranch.android.remotecontrol;

import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.provider.*;
import android.support.v4.app.*;
import android.text.*;
import android.text.format.*;
import android.view.*;
import android.util.Log;
import android.widget.*;

public class RemoteControlFragment extends Fragment {

    private TextView selectedTextView;
    private TextView workingTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_remote_control, parent, false);

	selectedTextView = (TextView) view.findViewById(R.id.fragment_remote_control_selectedTextView);
	workingTextView = (TextView) view.findViewById(R.id.fragment_remote_control_workingTextView);

	View.OnClickListener numberButtonListener = new View.OnClickListener() {
	    public void onClick(View view) {
		TextView textView = (TextView) view;
		String working = workingTextView.getText().toString();
		String text = textView.getText().toString();

		if (working.equals("0")) {
		    workingTextView.setText(text);
		}
		else {
		    workingTextView.setText(working + text);
		}
	    }
	};

	TableLayout tableLayout = (TableLayout) view.findViewById(R.id.fragment_remote_control_tableLayout);
	int number = 1;
	for (int i = 2; i < tableLayout.getChildCount() - 1; i++) {
	    TableRow row = (TableRow) tableLayout.getChildAt(i);
	    for (int j = 0; j < row.getChildCount(); j++) {
		Button button = (Button) row.getChildAt(j);
		button.setText("" + number);
		button.setOnClickListener(numberButtonListener);
		number++;
	    }
	}

	TableRow bottomRow = (TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1);

	Button deleteButton = (Button) bottomRow.getChildAt(0);
	deleteButton.setText("Delete");
	deleteButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View view) {
		workingTextView.setText("0");
	    }
	});

	Button zeroButton = (Button) bottomRow.getChildAt(1);
	zeroButton.setText("0");
	zeroButton.setOnClickListener(numberButtonListener);

	Button enterButton = (Button) bottomRow.getChildAt(2);
	enterButton.setText("Enter");
	enterButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View view) {
		CharSequence working = workingTextView.getText();
		if (working.length() > 0) {
		    selectedTextView.setText(working);
		}
		workingTextView.setText("0");
	    }
	});

	return view;
    }
}
