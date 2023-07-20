package com.example.eqtest.domain.equalizer.coefs

object FirCoefficients {

    val FIR = listOf(arrayOf<Double>(
        0.0002462606069579,0.0004942699473845,0.0007439892468201,0.0009953793806178,
        0.001248400880382,  0.00150301394047, 0.001759178424552,  0.00201685387224,
        0.002275999505768, 0.002536574236733, 0.002798536672895, 0.003061845125037,
        0.003326457613867, 0.003592331876992, 0.003859425375927, 0.004127695303172,
        0.004397098589324,  0.00466759191025, 0.004939131694302, 0.005211674129583,
        0.00548517517125, 0.005759590548874, 0.006034875773832, 0.006310986146745,
        0.00658787676496, 0.006865502530065, 0.007143818155444, 0.007422778173875,
        0.007702336945152, 0.007982448663752, 0.008263067366526, 0.008544146940432,
        0.008825641130284, 0.009107503546546, 0.009389687673139, 0.009672146875287,
        0.009954834407377,  0.01023770342085,  0.01052070697211,  0.01080379803046,
        0.01108692948605,  0.01137005415785,  0.01165312480162,  0.01193609411794,
        0.01221891476021,  0.01250153934268,  0.01278392044849,  0.01306601063773,
        0.01334776245548,  0.01362912843989,  0.01391006113026,   0.0141905130751,
        0.01447043684021,   0.0147497850168,  0.01502851022951,  0.01530656514454,
        0.01558390247772,  0.01586047500255,  0.01613623555834,  0.01641113705821,
        0.01668513249716,  0.01641113705821,  0.01613623555834,  0.01586047500255,
        0.01558390247772,  0.01530656514454,  0.01502851022951,   0.0147497850168,
        0.01447043684021,   0.0141905130751,  0.01391006113026,  0.01362912843989,
        0.01334776245548,  0.01306601063773,  0.01278392044849,  0.01250153934268,
        0.01221891476021,  0.01193609411794,  0.01165312480162,  0.01137005415785,
        0.01108692948605,  0.01080379803046,  0.01052070697211,  0.01023770342085,
        0.009954834407377, 0.009672146875287, 0.009389687673139, 0.009107503546546,
        0.008825641130284, 0.008544146940432, 0.008263067366526, 0.007982448663752,
        0.007702336945152, 0.007422778173875, 0.007143818155444, 0.006865502530065,
        0.00658787676496, 0.006310986146745, 0.006034875773832, 0.005759590548874,
        0.00548517517125, 0.005211674129583, 0.004939131694302,  0.00466759191025,
        0.004397098589324, 0.004127695303172, 0.003859425375927, 0.003592331876992,
        0.003326457613867, 0.003061845125037, 0.002798536672895, 0.002536574236733,
        0.002275999505768,  0.00201685387224, 0.001759178424552,  0.00150301394047,
        0.001248400880382,0.0009953793806178,0.0007439892468201,0.0004942699473845,
        0.0002462606069579
    ),
        arrayOf<Double>(
            -0.0001179794572092,-0.0002140712377644,-0.0002831766984932,-0.0003214192302272,
            -0.0003263894061758,-0.0002973423102361,-0.0002353377487716,-0.0001433156835324,
            -2.610115894091e-05,0.0001096648198173,0.0002556696331938,0.0004021473099509,
            0.0005381668740672,0.0006519844576609,0.0007314504918411,0.0007644611107973,
            0.0007394409940798,0.0006458432945764,0.0004746511133794,0.0002188642354676,
            -0.00012604543222,-0.0005617260535859, -0.00108660128937,-0.001695603328451,
            -0.002379996188582,-0.003127299801136,-0.003921322853285,-0.004742309491258,
            -0.005567201863772,-0.006370017188954,-0.007122334651288,-0.007793884072561,
            -0.008353225049407,-0.008768502206224,-0.009008259468747,-0.009042293906992,
            -0.008842527804312,-0.008383876248518,-0.007645086764461,-0.006609527353268,
            -0.005265899793036,-0.003608856193308,-0.001639498567261,0.0006342564406168,
            0.00319746260642, 0.006028090478536, 0.009097142727085,  0.01236894205243,
            0.01580159086713,  0.01934759751998,  0.02295465940318,  0.02656658899259,
            0.03012436483424,   0.0335672858202,  0.03683420389862,  0.03986480773158,
            0.04260092783003,   0.0449878324241,  0.04697548281618,  0.04851971724136,
            0.04958333333333,  0.04851971724136,  0.04697548281618,   0.0449878324241,
            0.04260092783003,  0.03986480773158,  0.03683420389862,   0.0335672858202,
            0.03012436483424,  0.02656658899259,  0.02295465940318,  0.01934759751998,
            0.01580159086713,  0.01236894205243, 0.009097142727085, 0.006028090478536,
            0.00319746260642,0.0006342564406168,-0.001639498567261,-0.003608856193308,
            -0.005265899793036,-0.006609527353268,-0.007645086764461,-0.008383876248518,
            -0.008842527804312,-0.009042293906992,-0.009008259468747,-0.008768502206224,
            -0.008353225049407,-0.007793884072561,-0.007122334651288,-0.006370017188954,
            -0.005567201863772,-0.004742309491258,-0.003921322853285,-0.003127299801136,
            -0.002379996188582,-0.001695603328451, -0.00108660128937,-0.0005617260535859,
            -0.00012604543222,0.0002188642354676,0.0004746511133794,0.0006458432945764,
            0.0007394409940798,0.0007644611107973,0.0007314504918411,0.0006519844576609,
            0.0005381668740672,0.0004021473099509,0.0002556696331938,0.0001096648198173,
            -2.610115894091e-05,-0.0001433156835324,-0.0002353377487716,-0.0002973423102361,
            -0.0003263894061758,-0.0003214192302272,-0.0002831766984932,-0.0002140712377644,
            -0.0001179794572092
        ),

        arrayOf<Double>(
            0.0001577219656063,0.0002723368671717,0.0003076512912154,0.0002362603206041,
            4.487590126859e-05,-0.0002621328748862,-0.0006616360334921, -0.00111340700456,
            -0.001564505520088,-0.001955934009542,-0.002230765264135,-0.002342671500493,
            -0.002263648412767,-0.001989748846187,-0.001543826509471,-0.0009746265671619,
            -0.0003520123405854,0.0002413662321364,0.0007211397956115, 0.001013750128429,
            0.001068852802841,0.0008698637769723,0.0004409984903602,-0.0001505505462544,
            -0.0007981536777384,-0.001365205403227,-0.001699973333905,-0.001654562260327,
            -0.001106071044839,2.245442230329e-05, 0.001743896786028, 0.003994329825172,
            0.006627850690996, 0.009420497812587,  0.01208386757715,   0.0142879890411,
            0.01569191978388,  0.01597950850667,   0.0148969513692,  0.01228825537662,
            0.008124592454124, 0.002523823941693,-0.004242805218459, -0.01175870897619,
            -0.01948526875502,  -0.0267994060303, -0.03304288282544, -0.03757941843057,
            -0.03985464632215, -0.03945331052833, -0.03614800445618, -0.02993422579257,
            -0.0210475399509,-0.009960135695187,  0.00264410781968,   0.0159149118598,
            0.02889812207947,  0.04061056376972,  0.05012095096208,  0.05662974902512,
            0.05954072068328,  0.05662974902512,  0.05012095096208,  0.04061056376972,
            0.02889812207947,   0.0159149118598,  0.00264410781968,-0.009960135695187,
            -0.0210475399509, -0.02993422579257, -0.03614800445618, -0.03945331052833,
            -0.03985464632215, -0.03757941843057, -0.03304288282544,  -0.0267994060303,
            -0.01948526875502, -0.01175870897619,-0.004242805218459, 0.002523823941693,
            0.008124592454124,  0.01228825537662,   0.0148969513692,  0.01597950850667,
            0.01569191978388,   0.0142879890411,  0.01208386757715, 0.009420497812587,
            0.006627850690996, 0.003994329825172, 0.001743896786028,2.245442230329e-05,
            -0.001106071044839,-0.001654562260327,-0.001699973333905,-0.001365205403227,
            -0.0007981536777384,-0.0001505505462544,0.0004409984903602,0.0008698637769723,
            0.001068852802841, 0.001013750128429,0.0007211397956115,0.0002413662321364,
            -0.0003520123405854,-0.0009746265671619,-0.001543826509471,-0.001989748846187,
            -0.002263648412767,-0.002342671500493,-0.002230765264135,-0.001955934009542,
            -0.001564505520088, -0.00111340700456,-0.0006616360334921,-0.0002621328748862,
            4.487590126859e-05,0.0002362603206041,0.0003076512912154,0.0002723368671717,
            0.0001577219656063
        ),

        arrayOf<Double>(
            -6.035276281093e-05,-5.259283485643e-06,9.314677399982e-05,0.0001238692806084,
            2.369714794152e-05,-0.0001582508251174,-0.0002630322662586,-0.0001013903738137,
            0.0004244933260753, 0.001222296997959, 0.001997089640453, 0.002350733619688,
            0.001961665251825,0.0007648527181267,-0.0009617083243387,-0.002664102717737,
            -0.003724060116986,-0.003731545740907,-0.002692711718971,-0.001062707359214,
            0.0004349158900755, 0.001139910094933,0.0007931680470956,-0.0002861752217475,
            -0.001294043543676,-0.001296541463031,0.0002911979289553,  0.00332013857841,
            0.00681929887296, 0.009293356453545, 0.009323293237665,  0.00623261451456,
            0.0005183206710248,-0.006185078223827, -0.01165458748156, -0.01395662622398,
            -0.01229569546553,-0.007444907110524,-0.001513166232289, 0.002922585276811,
            0.003996958702657, 0.001539775659577,-0.002621628697028,-0.005281860277475,
            -0.003253059190532, 0.004982297442654,  0.01807466183741,   0.0316877527852,
            0.03970190123907,   0.0364540605491,  0.01924515423655,-0.009879795956173,
            -0.04391753880774, -0.07258173734591, -0.08548581094099,   -0.075820645287,
            -0.0432134611401, 0.005369427526045,  0.05718903226769,  0.09741680724128,
            0.1137883783008,  0.09741680724128,  0.05718903226769, 0.005369427526045,
            -0.0432134611401,   -0.075820645287, -0.08548581094099, -0.07258173734591,
            -0.04391753880774,-0.009879795956173,  0.01924515423655,   0.0364540605491,
            0.03970190123907,   0.0316877527852,  0.01807466183741, 0.004982297442654,
            -0.003253059190532,-0.005281860277475,-0.002621628697028, 0.001539775659577,
            0.003996958702657, 0.002922585276811,-0.001513166232289,-0.007444907110524,
            -0.01229569546553, -0.01395662622398, -0.01165458748156,-0.006185078223827,
            0.0005183206710248,  0.00623261451456, 0.009323293237665, 0.009293356453545,
            0.00681929887296,  0.00332013857841,0.0002911979289553,-0.001296541463031,
            -0.001294043543676,-0.0002861752217475,0.0007931680470956, 0.001139910094933,
            0.0004349158900755,-0.001062707359214,-0.002692711718971,-0.003731545740907,
            -0.003724060116986,-0.002664102717737,-0.0009617083243387,0.0007648527181267,
            0.001961665251825, 0.002350733619688, 0.001997089640453, 0.001222296997959,
            0.0004244933260753,-0.0001013903738137,-0.0002630322662586,-0.0001582508251174,
            2.369714794152e-05,0.0001238692806084,9.314677399982e-05,-5.259283485643e-06,
            -6.035276281093e-05
        ),

        arrayOf<Double>(
            -8.693533318667e-05,-0.0003175439173303,-0.0002078994983094,0.0001123073124066,
            4.230885283868e-05,-0.0002201920617418, 0.000247774793834, 0.001296246442018,
            0.001303530410347,-0.0004218199488705,-0.002036812882934,-0.001534450310507,
            0.0001326991635116,0.0004280469066022,-0.0005585210625941,-1.319353014763e-05,
            0.002668697789159, 0.003788280898101,0.0005399764618842,-0.003930191635653,
            -0.00426611138896,-0.0007245008695288, 0.001174213283167,-0.0005612825369249,
            -0.0009586250984077, 0.003510863432358, 0.007533042681285, 0.003722428790506,
            -0.005310717909617,-0.008953760766019,  -0.0035999909726,   0.0019469655036,
            0.0002816275167324,-0.002484510690493,  0.00326491255469,  0.01275787559515,
            0.01082484502236, -0.00482259339927, -0.01665360612233, -0.01098849803031,
            0.001688171044515, 0.002798758623221,-0.004349036157431,0.0009744818118448,
            0.02066680654503,  0.02691550628908, 0.001338841602649, -0.03118259447089,
            -0.03166963291533,-0.003718561861419, 0.009674970382442,-0.006207344250877,
            -0.007425688262523,  0.04053233953243,  0.08680947754338,  0.04105849024766,
            -0.09210069532342,  -0.1755874048906, -0.08705424117605,   0.1133134626004,
            0.2216295519067,   0.1133134626004, -0.08705424117605,  -0.1755874048906,
            -0.09210069532342,  0.04105849024766,  0.08680947754338,  0.04053233953243,
            -0.007425688262523,-0.006207344250877, 0.009674970382442,-0.003718561861419,
            -0.03166963291533, -0.03118259447089, 0.001338841602649,  0.02691550628908,
            0.02066680654503,0.0009744818118448,-0.004349036157431, 0.002798758623221,
            0.001688171044515, -0.01098849803031, -0.01665360612233, -0.00482259339927,
            0.01082484502236,  0.01275787559515,  0.00326491255469,-0.002484510690493,
            0.0002816275167324,   0.0019469655036,  -0.0035999909726,-0.008953760766019,
            -0.005310717909617, 0.003722428790506, 0.007533042681285, 0.003510863432358,
            -0.0009586250984077,-0.0005612825369249, 0.001174213283167,-0.0007245008695288,
            -0.00426611138896,-0.003930191635653,0.0005399764618842, 0.003788280898101,
            0.002668697789159,-1.319353014763e-05,-0.0005585210625941,0.0004280469066022,
            0.0001326991635116,-0.001534450310507,-0.002036812882934,-0.0004218199488705,
            0.001303530410347, 0.001296246442018, 0.000247774793834,-0.0002201920617418,
            4.230885283868e-05,0.0001123073124066,-0.0002078994983094,-0.0003175439173303,
            -8.693533318667e-05
        ),

        arrayOf<Double>(
            5.567162931323e-05,0.0001583605765499,-6.685749215842e-05,-0.0003675938988896,
            -8.959721323281e-05, 0.000523456758487,0.0004027271218223,-0.0005187276018778,
            -0.0007984219589492,0.0002773543695735, 0.001151287700337,0.0002153460818637,
            -0.001312915795162,-0.0008948735526178, 0.001151363954966, 0.001618452018016,
            -0.0005933061249987,-0.002187210600957,-0.0003413941687023, 0.002387420725207,
            0.00152246951046,-0.002043788925105,-0.002716449779137, 0.001074054248276,
            0.003620728712562,0.0004676686753023,-0.003921271006068,-0.002370652480229,
            0.003365096178839,  0.00427896306873,-0.001834260583972,-0.005737568123765,
            -0.0005940966227471, 0.006269495174888, 0.003616312924845,-0.005473706122823,
            -0.006710224383036, 0.003128091333034, 0.009187117653572,0.0007206048939166,
            -0.01028412965019,-0.005697114647792, 0.009285503674858,  0.01108032825975,
            -0.005654384164092, -0.01583097930139,-0.0008471202758461,  0.01865232139827,
            0.01007208629744, -0.01804759309139, -0.02145575351221,  0.01228592869608,
            0.03404640852782,0.0009735695021528, -0.04660114935178, -0.02637118119778,
            0.05773647878407,  0.07985719640039, -0.06611363794059,  -0.3067742460251,
            0.5727501879254,  -0.3067742460251, -0.06611363794059,  0.07985719640039,
            0.05773647878407, -0.02637118119778, -0.04660114935178,0.0009735695021528,
            0.03404640852782,  0.01228592869608, -0.02145575351221, -0.01804759309139,
            0.01007208629744,  0.01865232139827,-0.0008471202758461, -0.01583097930139,
            -0.005654384164092,  0.01108032825975, 0.009285503674858,-0.005697114647792,
            -0.01028412965019,0.0007206048939166, 0.009187117653572, 0.003128091333034,
            -0.006710224383036,-0.005473706122823, 0.003616312924845, 0.006269495174888,
            -0.0005940966227471,-0.005737568123765,-0.001834260583972,  0.00427896306873,
            0.003365096178839,-0.002370652480229,-0.003921271006068,0.0004676686753023,
            0.003620728712562, 0.001074054248276,-0.002716449779137,-0.002043788925105,
            0.00152246951046, 0.002387420725207,-0.0003413941687023,-0.002187210600957,
            -0.0005933061249987, 0.001618452018016, 0.001151363954966,-0.0008948735526178,
            -0.001312915795162,0.0002153460818637, 0.001151287700337,0.0002773543695735,
            -0.0007984219589492,-0.0005187276018778,0.0004027271218223, 0.000523456758487,
            -8.959721323281e-05,-0.0003675938988896,-6.685749215842e-05,0.0001583605765499,
            5.567162931323e-05
        ),
    )
}