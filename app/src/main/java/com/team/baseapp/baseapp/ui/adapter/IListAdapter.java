package com.team.baseapp.baseapp.ui.adapter;

import java.util.List;

/**
 * list adapter interface
 * Created by lynnzc on 16-4-16.
 */
public interface IListAdapter {
    void add(Object data);

    void addAll(List<Object> datas);

    void clear();
}
