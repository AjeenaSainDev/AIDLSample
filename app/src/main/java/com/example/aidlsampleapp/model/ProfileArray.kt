package com.example.aidlsampleapp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ajeena on 04-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class ProfileArray : Cloneable{
    @SerializedName("profileId")
     var profile_id  = ""  /**define setters and getters in kotlin**/
    private set
    get () = field

    @SerializedName("profileName")
     var profileName: String= ""
        private set
        get () = field

    @SerializedName("passwordProtected")
     var passwordProtected: String= ""
        private set
        get () = field

    @SerializedName("unique")
     var unique_id: String = "aju"
        private set
        get () = field

    @SerializedName("entitlements")
    private var entitlements: List<String>? = null
        private set
        get () = field

    constructor(profile_id: String, profileName: String) {
        this.profile_id = profile_id
        this.profileName = profileName
        /*this.passwordProtected = passwordProtected
        this.unique_id = unique_id
        this.entitlements = entitlements*/


    }
    data class ProfileArray(var profile_id: String, var profileName: String){

  }


}