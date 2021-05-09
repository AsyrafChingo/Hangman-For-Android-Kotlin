package universitas.surabaya

import android.os.Parcel
import android.os.Parcelable

class Hangman() : Parcelable {
    var playerName : String = ""
    var theme : String = ""
    var level : String = ""
    var image : Boolean= false

    constructor(parcel: Parcel) : this() {
        playerName = parcel.readString()
        theme = parcel.readString()
        level = parcel.readString()
        image = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(playerName)
        parcel.writeString(theme)
        parcel.writeString(level)
        parcel.writeByte(if (image) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hangman> {
        override fun createFromParcel(parcel: Parcel): Hangman {
            return Hangman(parcel)
        }

        override fun newArray(size: Int): Array<Hangman?> {
            return arrayOfNulls(size)
        }
    }
}