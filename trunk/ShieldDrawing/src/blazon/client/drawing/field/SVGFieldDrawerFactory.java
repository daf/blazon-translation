package blazon.client.drawing.field;


import org.vectomatic.dom.svg.OMSVGDefsElement;

import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision;

public class SVGFieldDrawerFactory {

	public SVGFieldDrawer createDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		if (field == null) {
			return null;
		}
		String divisionName = field.getShieldDivision().getName();
		if (divisionName.equals(ShieldDivision.BARRY) || divisionName.equals(ShieldDivision.FESS) || divisionName.equals(ShieldDivision.TIERCED_FESS)) {
			return new SVGFessBarryDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.BEND)) {
			return new SVGBendDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.BEND_SINISTER)) {
			return new SVGBendSinisterDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.BENDY)) {
			return new SVGBendyDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.BENDY_SINISTER)) {
			return new SVGBendySinisterDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.CHEQUY)) {
			return new SVGChequyDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.CHEVRON)) {
			return new SVGChevronDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.CHEVRON_REVERSED)) {
			return new SVGChevronReversedDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.CHEVRONNY)) {
			return new SVGChevronnyDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.CHEVRONNY_REVERSED)) {
			return new SVGChevronnyReversed(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.CROSS)) {
			return new SVGCrossDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.GYRONNY)) {
			return new SVGGyronnyDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.LOZENGY)) {
			return new SVGLozengyDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.NONE)) {
			return new SVGPlainFieldDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.PALE) || divisionName.equals(ShieldDivision.PALY)) {
			return new SVGPalePalyDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.PALL)) {
			return new SVGPallDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.PALL_REVERSED)) {
			return new SVGPallReversedDrawer(field, defs, shieldWidth, shieldHeight);
		} else if (divisionName.equals(ShieldDivision.SALTIRE)) {
			return new SVGSaltireDrawer(field, defs, shieldWidth, shieldHeight);
		} 
		return new SVGPlainFieldDrawer(field, defs, shieldWidth, shieldHeight);
	}
}
