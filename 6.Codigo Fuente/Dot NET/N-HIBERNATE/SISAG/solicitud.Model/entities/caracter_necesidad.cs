using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class caracter_necesidad
    {
        private string _ID;
        private string _NOMBRE;
        private IList<detalle_necesidad> _DETALLE_NECESIDAD = new List<detalle_necesidad>();

        public caracter_necesidad()
        {
            throw new System.NotImplementedException();
        }

        public caracter_necesidad(string pID, string pNombre)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string NOMBRE
        {
            get { return _NOMBRE; }
            set { _NOMBRE = value; }
        }

        public IList<detalle_necesidad> DETALLE_NECESIDAD
        {
            get { return _DETALLE_NECESIDAD; }
            set { _DETALLE_NECESIDAD = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public caracter_necesidad recuperarObjeto()
        {
            throw new System.NotImplementedException();
        }

        public IList<caracter_necesidad> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }
    }
}
