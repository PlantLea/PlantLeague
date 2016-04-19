package com.team.baseapp.baseapp.ui.adapter;

import java.util.List;

/**
 * list adapter interface
 * Created by lynnzc on 16-4-16.
 */
public interface IListAdapter<T> {
    void add(T data);

    void addAll(List<T> datas);

    void clear();
}
