package sh.calaba.espressobackend.actions.preferences;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.content.SharedPreferences;

/**
 * Allows reading of SharedPreferences.
 * 
 * See Ruby API docs for more info:
 * https://github.com/calabash/calabash-android/blob/master/documentation/ruby_api.md
 * 
 * @author Juan Delgado (juan@ustwo.co.uk)
 */
public class GetPreferences implements Action {

	@Override
	public Result execute(String... args) {
		
		SharedPreferences preferences = null;
		
		try{
			preferences = PreferencesUtils.getPreferencesFromArgs(args, EspressoInstrumentationBackend.instrumentation.getTargetContext());
		} catch(Exception e){
			return Result.fromThrowable(e);
		}
		
		Result result = Result.successResult();
		PreferencesUtils.addPreferencesToResult(preferences, result);
		
		return result;
	}
	
	@Override
	public String key() {
		return "get_preferences";
	}
}