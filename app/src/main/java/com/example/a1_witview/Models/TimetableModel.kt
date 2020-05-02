package com.example.a1_witview.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimetableModel(var id: Long = 0,
                          var title: String = "",

                            var subject: String = "",
                            var lecturer: String = "",
                            var room: String = "",

                            var spinnerT: String = "",
                            var spinnerD: String = ""

                          ): Parcelable