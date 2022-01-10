package com.team7.regengers.heroDetails;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team7.regengers.R;
import com.team7.regengers.networking.JsonItemResponse;
import com.team7.regengers.networking.JsonMediaResponse;
import com.team7.regengers.networking.JsonUrlsResponse;

import java.util.List;

public class MyExpandableListAdapter implements ExpandableListAdapter {

    private List<JsonMediaResponse> mediaList;
    private List<JsonUrlsResponse> extraUrls;
    private Context myParentContext;
    private int groupPos;

    public MyExpandableListAdapter(List<JsonMediaResponse> mediaList, List<JsonUrlsResponse> extraUrls, Context myParentContext) {
        this.mediaList = mediaList;
        this.extraUrls = extraUrls;
        this.myParentContext = myParentContext;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return mediaList.size()+1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(groupPosition == 4) return extraUrls.size();
        else return mediaList.get(groupPosition).getAvailable();
    }

    @Override
    public Object getGroup(int groupPosition) {
        if(groupPosition == 4) return extraUrls;
        else return mediaList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if(groupPosition == 4) return extraUrls.get(childPosition);
        else return mediaList.get(groupPosition).getItems().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LinearLayout groupLayoutView = new LinearLayout(myParentContext);
        groupLayoutView.setOrientation(LinearLayout.VERTICAL);

        String groupText = getGroupName(groupPosition);
        TextView groupTextView = new TextView(myParentContext);
        groupTextView.setText(groupText);
        groupTextView.setTextSize(24);
        groupTextView.setPadding(36,16,0,16);
        groupLayoutView.addView(groupTextView);

        return groupLayoutView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText;
        if(groupPosition == 4){
        JsonUrlsResponse childObj = (JsonUrlsResponse) this.getChild(groupPosition, childPosition);
         childText = childObj.getType();
        } else{
            JsonItemResponse childObj = (JsonItemResponse) this.getChild(groupPosition, childPosition);
            childText = childObj.getName();
        }

        // Create a TextView to display child text.
        TextView childTextView = new TextView(myParentContext);
        childTextView.setText(childText);
        childTextView.setTextSize(20);
        childTextView.setPadding(52,16,0,16);

        return childTextView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    public String getGroupName(int i) {

            switch (i) {
                case 0:
                    return "Comics";
                case 1:
                    return "Series";
                case 2:
                    return "Stories";
                case 3:
                    return "Events";
                case 4:
                    return "Extra Info";
                default:
                     return "";
            }
    }

}
