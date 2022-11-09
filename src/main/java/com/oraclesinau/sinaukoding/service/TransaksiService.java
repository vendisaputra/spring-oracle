package com.oraclesinau.sinaukoding.service;

import com.oraclesinau.sinaukoding.model.Transaksi;
import com.oraclesinau.sinaukoding.model.TransaksiDTO;
import com.oraclesinau.sinaukoding.repository.TransaksiRepository;
import com.oraclesinau.sinaukoding.utils.ManyData;
import com.oraclesinau.sinaukoding.utils.RestResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransaksiService {
    private final TransaksiRepository repository;

    public RestResult getData(){
        ManyData<Transaksi> result = new ManyData<>(repository.getTransaksi(), Transaksi.class);

        return new RestResult(
                result.getData(),
                result.getMessage(),
                result.getError()
        );
    }

    public RestResult saveTransaksi(TransaksiDTO param){
        ManyData<Transaksi> result = new ManyData<>(repository.saveTransaksi(param), Transaksi.class);

        return new RestResult(
                result.getData(),
                result.getMessage(),
                result.getError()
        );
    }


}
