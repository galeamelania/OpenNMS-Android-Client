package org.opennms.gsoc;

import org.opennms.gsoc.about.AboutFragment;
import org.opennms.gsoc.alarms.AlarmsListFragment;
import org.opennms.gsoc.listeners.TabListener;
import org.opennms.gsoc.nodes.NodesListFragment;
import org.opennms.gsoc.outages.OutagesListFragment;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * The class contains the tab management of the application. The assignment of each tab to its activity is performed through intents. 
 * @author melania galea
 *
 */
public class OpenNMSAndroidAppActivity extends SherlockFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		bar.addTab(bar.newTab()
				.setText("about")
				.setTabListener(new TabListener<AboutFragment>(
						this, "About", AboutFragment.class))
						.setIcon(R.drawable.o));

		bar.addTab(bar.newTab()
				.setText("Nodes")
				.setTabListener(new TabListener<NodesListFragment>(
						this, "Nodes", NodesListFragment.class))
						.setIcon(R.drawable.display));

		bar.addTab(bar.newTab()
				.setText("Outages")
				.setTabListener(new TabListener<OutagesListFragment>(
						this, "Outages", OutagesListFragment.class))
						.setIcon(R.drawable.ekg));

		bar.addTab(bar.newTab()
				.setText("Alarms")
				.setTabListener(new TabListener<AlarmsListFragment>(
						this, "Alarms", AlarmsListFragment.class))
						.setIcon(R.drawable.clock));

		if (savedInstanceState != null) {
			bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
		}
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
	}

}