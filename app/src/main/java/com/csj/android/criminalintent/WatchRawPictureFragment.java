package com.csj.android.criminalintent;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by 79021 on 2017/1/17.
 */

public class WatchRawPictureFragment extends DialogFragment {

    private static final String ARG_PHOTO = "com.csj.android.criminalintent.PHOTO";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_watch_raw_picture, null);
        ImageView rawPictureImageView = (ImageView) view.findViewById(R.id.watch_raw_picture_image_view);
        File photoFile = (File) getArguments().getSerializable(ARG_PHOTO);
        PictureUtils.updatePictureView(rawPictureImageView, photoFile, getActivity());

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.picture_detail_info)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

    public static WatchRawPictureFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, photoFile);
        WatchRawPictureFragment fragment = new WatchRawPictureFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
