package id.ac.unpas.tugas2.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas.tugas2.model.DataImunisasiAnak
import id.ac.unpas.tugas2.persistences.DataImunisasiAnakDao
import id.ac.unpas.tugas2.ui.theme.Purple700
import id.ac.unpas.tugas2.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPendaftaranImunisasi(dataImunisasiAnakDao: DataImunisasiAnakDao) {
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val umur = remember { mutableStateOf(TextFieldValue("")) }
    val berat = remember { mutableStateOf(TextFieldValue("")) }
    val tinggi = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Umur") },
            value = umur.value,
            onValueChange = {
                umur.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "5") }
        )

        OutlinedTextField(
                label = { Text(text = "Berat Badan") },
        value = berat.value,
        onValueChange = {
            berat.value = it
        },
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType =
        KeyboardType.Decimal),
        placeholder = { Text(text = "5") }
        )
        OutlinedTextField(
            label = { Text(text = "Tinggi Badan") },
            value = tinggi.value,
            onValueChange = {
                tinggi.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "5") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = DataImunisasiAnak(id, nama.value.text,
                    umur.value.text, berat.value.text, tinggi.value.text)
                scope.launch {
                    dataImunisasiAnakDao.insertAll(item)
                }
                nama.value = TextFieldValue("")
                umur.value = TextFieldValue("")
                berat.value = TextFieldValue("")
                tinggi.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                umur.value = TextFieldValue("")
                berat.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

