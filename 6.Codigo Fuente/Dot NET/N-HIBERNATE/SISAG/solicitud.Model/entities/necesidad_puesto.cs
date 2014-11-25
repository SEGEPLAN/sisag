using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class necesidad_puesto
    {
        private string _ID;
        private string _DESCRIPCION;
        private int _ESTADO;
        private tipo_puesto _TIPO_PUESTO = new tipo_puesto();
        private detalle_necesidad _DETALLE_NECESIDAD = new detalle_necesidad();

        public necesidad_puesto()
        {
            throw new System.NotImplementedException();
        }

        public necesidad_puesto(string pID, string pDescripcion, string pEstado, tipo_puesto pTipo_Puesto, detalle_necesidad pDetalle)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string DESCRIPCION
        {
            get { return _DESCRIPCION; }
            set { _DESCRIPCION = value; }
        }

        public int ESTADO
        {
            get { return _ESTADO; }
            set { _ESTADO = value; }
        }

        public detalle_necesidad DETALLE_NECESIDAD
        {
            get { return _DETALLE_NECESIDAD; }
            set { _DETALLE_NECESIDAD = value; }
        }

        public tipo_puesto TIPO_PUESTO
        {
            get { return _TIPO_PUESTO; }
            set { _TIPO_PUESTO = value; }
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public necesidad_puesto recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<necesidad_puesto> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }

        public bool Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public IList<necesidad_puesto> recuperarTipo_puesto(tipo_puesto pTipo)
        {
            throw new System.NotImplementedException();
        }

        public IList<necesidad_puesto> recuperarDetalle(detalle_necesidad pDetalle)
        {
            throw new System.NotImplementedException();
        }
    }
}
