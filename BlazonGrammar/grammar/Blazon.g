grammar Blazon;

options {
  language = Java;
}

@header {
  package blazon.server.grammar;
  import blazon.shared.shield.Shield;
  import blazon.shared.shield.ShieldLayer;
  import blazon.shared.shield.tinctures.Tinctures;
  import blazon.shared.shield.tinctures.Tincture;
}

@lexer::header {
  package blazon.server.grammar;
}

shield returns [Shield s]
    :   field {
            $s = Shield.build($field.layer);        }
    ;


field returns [ShieldLayer layer]
    :   { Tinctures tinctures = new Tinctures(); }
        tincture[tinctures] 'plain'? {
            tinctures.addTincture($tincture.tincture);
            $layer = ShieldLayer.build(tinctures);
        }
    ;

tincture [Tinctures tinctures] returns [Tincture tincture]    
    : COLOUR {$tincture = tinctures.createTincture($COLOUR.text);}
    | METAL {$tincture = tinctures.createTincture($METAL.text);}
    | FUR {$tincture = tinctures.createTincture($FUR.text);}
    ;
    
COLOUR  :   'azure' | 'gules' | 'vert' | 'sable' | 'purpure'
        ;

METAL   :   'or' | 'argent'
        ;

//could be refactored - leave it for now to be easy to debug
FUR :   'ermine' | 'ermines' | 'erminois' | 'pean'
        |'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point'
        |'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point'
    ;

WS  :   (' '|'\t')+ {$channel=HIDDEN;}
    ;