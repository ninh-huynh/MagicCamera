package com.seu.magiccamera.common.view.edit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;

import com.seu.magicfilter.display.MagicImageDisplay;

public abstract class ImageEditFragment extends Fragment{
	protected MagicImageDisplay mMagicDisplay;
	protected Context mContext;
	protected onHideListener mOnHideListener;
	public ImageEditFragment(Context context, MagicImageDisplay magicDisplay){
		this.mMagicDisplay = magicDisplay;
		this.mContext = context;
	}
	
	public void onHide(){
		if(isChanged()){
			AlertDialog.Builder builder = new Builder(mContext);
			builder.setTitle("��ʾ").setMessage("�Ƿ�Ӧ���޸ģ�").setNegativeButton("��", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {	
					onDialogButtonClick(dialog);
					mMagicDisplay.commit();					
				}
			}).setPositiveButton("��", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {	
					onDialogButtonClick(dialog);
					mMagicDisplay.restore();
				}
			}).create().show();
		}else{
			mOnHideListener.onHide();
		}
	}
	
	public void setOnHideListener(onHideListener l){
		this.mOnHideListener = l;
	}
	
	protected abstract boolean isChanged();
	
	protected void onDialogButtonClick(DialogInterface dialog){
		if(mOnHideListener != null)
			mOnHideListener.onHide();
		dialog.dismiss();
	}
	
	public interface onHideListener{
		void onHide();
	}
}
